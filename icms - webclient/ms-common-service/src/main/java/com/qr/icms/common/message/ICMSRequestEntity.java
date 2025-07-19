package com.qr.icms.common.message;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import java.util.Map;

public class ICMSRequestEntity<T> {

    private final String serviceName;

    private final HttpMethod requestType;

    private final Map<String, String> pathVariables;
    private final Map<String, String> queryParams;
    private final Map<String, String> headers;
    private final Class<T> requestBody;
    private final Class<T> responseType;

    public ICMSRequestEntity(String serviceName, HttpMethod requestType, Map<String, String> pathVariables,
                             Map<String, String> queryParams, Map<String, String> headers, Class<T> requestBody, Class<T> responseType) {
        this.serviceName = serviceName;
        this.requestType = requestType;
        this.pathVariables = pathVariables;
        this.queryParams = queryParams;
        this.headers = headers;
        this.requestBody = requestBody;
        this.responseType = responseType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public HttpMethod getRequestType() {
        return requestType;
    }

    public Map<String, String> getPathVariables() {
        return pathVariables;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Class<T> getRequestBody() {
        return requestBody;
    }

    public Class<T> getResponseType() {
        return responseType;
    }
}
