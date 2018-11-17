/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.objectfrontier.sample.web.client;

/**
 * @author prassie
 * @since  Oct 03, 2006
 */
public class HttpClientDemo {

    private void run(String[] args) throws Exception {

        String url = "http://www.google.com/search?q=httpClient";
        log(RequestHelper.init().requestString(url));
    }

    public static void main(String[] args) {
        try {
            new HttpClientDemo().run(args);
        } catch (Exception e) {
            log(e);
        }
    }

    private static void log(Object o) {
        if (o instanceof Throwable) {
            ((Throwable)o).printStackTrace(System.err);
        } else {
            System.out.println(o);
        }
    }
}
