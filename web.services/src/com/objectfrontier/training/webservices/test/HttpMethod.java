package com.objectfrontier.training.webservices.test;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;

public enum HttpMethod {

    GET, POST, PUT, DELETE;

    public HttpUriRequest build(String uri) {

        switch(this) {
            case GET    : { return new HttpGet(uri);    }
            case POST   : { return new HttpPost(uri);   }
            case PUT    : { return new HttpPut(uri);    }
            case DELETE : { return new HttpDelete(uri); }
        }
        return null;
    }
}

