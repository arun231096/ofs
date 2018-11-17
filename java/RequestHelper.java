/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.objectfrontier.training.ws.test.servlet;

import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.objectfrontier.training.ws.model.AppErrorCode;
import com.objectfrontier.training.ws.model.AppException;
import com.objectfrontier.training.ws.model.JsonConverter;

/**
 * @author prassie
 * @since  Oct 03, 2006
 */
public class RequestHelper {

    private static String baseUrl;
    public static void setBaseUrl(String baseUrl) {
        RequestHelper.baseUrl = baseUrl;
    }

    public static RequestHelper create() { return new RequestHelper(); }

    private String uri;
    private HttpMethod method = HttpMethod.GET;
    private Map<String, String> headers;
    private Object input;
    private boolean isSecured;

    public RequestHelper setUri	   (String 			    uri	   )   { this.uri 	    = uri;       return this; }
    public RequestHelper setMethod (HttpMethod 			method )   { this.method    = method;    return this; }
    public RequestHelper setHeaders(Map<String, String> headers)   { this.headers   = headers;   return this; }
    public RequestHelper setInput  (Object 			    input  )   { this.input     = input;     return this; }
    public RequestHelper setSecured(boolean 		    isSecured) { this.isSecured = isSecured; return this; }

    private String authenticatedSessionId;
    public void setSecureDetails(HttpResponse response) {

        Header header = response.getFirstHeader("Set-Cookie");
        String value = header.getValue();
        int start = value.indexOf("JSESSIONID=") + 11; // "JSESSIONID=".length() = 11
        int end   = value.indexOf(";", start);
        String sessionID = value.substring(start, end);
        authenticatedSessionId = sessionID;
    }

    public HttpUriRequest build(String uri) throws Exception { this.uri = uri; return build(); }
    public HttpUriRequest build() throws Exception {

        HttpUriRequest request = method.build(baseUrl + uri);

        if (headers != null) {
            headers.forEach((k, v) -> request.addHeader(k, v));
        }

        if (isSecured) {
            request.addHeader("Cookie", "JSESSIONID="+ authenticatedSessionId);
        }

        if (input != null) {
            StringEntity inputEntity = new StringEntity(JsonConverter.toJson(input));
            inputEntity.setContentType(ContentType.APPLICATION_JSON.getMimeType());
            HttpEntityEnclosingRequest entityRequest = (HttpEntityEnclosingRequest) request;
            entityRequest.setEntity(inputEntity);
        }

        return request;
    }

    public HttpEntity requestEntity() throws Exception {
        HttpResponse response = requestRaw();
        HttpEntity responseEntity = handleResponse(response);
        return responseEntity;
    }

    public HttpResponse requestRaw(String uri) throws Exception { this.uri = uri; return requestRaw(); }
    public HttpResponse requestRaw() throws Exception {
        HttpUriRequest request = build();
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        return response;
    }

    private static HttpEntity handleResponse(HttpResponse response) {

        int responseStatusCode = getStatus(response);
        HttpEntity entity = response.getEntity();

        // success responses
        if (responseStatusCode < 300) { return entity; }

        // failure responses
        String errResponse;
        try {
            errResponse = EntityUtils.toString(entity);
        } catch (Exception e) {
            throw new AppException(e);
        }

        try {
            List<AppErrorCode> errorCodes = JsonConverter.toList(errResponse, AppErrorCode.class);
            throw new AppException(errorCodes);
        } catch (Exception e) {
            // if unable to convert AppErrCode, throw with original error response
            throw new AppException(e);
        }
    }

    public String requestString(String uri) throws Exception { this.uri = uri; return requestString(); }
    public String requestString() throws Exception { return EntityUtils.toString(requestEntity()); }

    public <T> T requestObject(String uri, Class<? extends T> type) throws Exception { this.uri = uri; return requestObject(type); }
    public <T> T requestObject(Class<? extends T> type) throws Exception {
        return JsonConverter.toObject(EntityUtils.toString(requestEntity()), type);
    }

    public static String asString(HttpResponse response) throws Exception {
        return EntityUtils.toString(response.getEntity());
    }

    public static int getStatus(HttpResponse response) {
        return response.getStatusLine().getStatusCode();
    }
}
