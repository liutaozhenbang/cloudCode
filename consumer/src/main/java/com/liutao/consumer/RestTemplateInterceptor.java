package com.liutao.consumer;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * .
 * Created by liutao20 on 2020/7/21
 */
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        ClientHttpResponse response = execution.execute(request, body);
        tranceRequest(request,  body);
        return response;
    }

    private void tranceRequest(HttpRequest request, byte[] body) throws UnsupportedEncodingException {
//        System.out.println("======= request begin ========");
//
//        System.out.println("uri : {}" + request.getURI());
//        System.out.println("method : {}" + request.getMethod());
//        System.out.println("headers : {}" + request.getHeaders());
//        System.out.println("request body : {}" + new String(body, "UTF-8"));
//
//        System.out.println("======= request end ========");
    }

}
