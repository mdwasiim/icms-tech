package com.qr.icms.common.webclient;

import com.qr.icms.common.message.ICMSRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;

@Component
public class WebClientService {

    private final WebClient.Builder webClientBuilder;
    private final LoadBalancerClient loadBalancerClient;

    @Autowired
    public WebClientService(WebClient.Builder webClientBuilder, LoadBalancerClient loadBalancerClient){
        this.webClientBuilder = webClientBuilder;
        this.loadBalancerClient = loadBalancerClient;
    }

    public WebClient.Builder getWebClientBuilder() {
        return this.webClientBuilder;
    }

    public <T> Mono<ResponseEntity<T>> call(ICMSRequestEntity icmsRequestEntity) {
        Mono<ResponseEntity<T>> responseEntity = null;

        String url = loadBalancerClient.choose(icmsRequestEntity.getServiceName()).getUri().toString();

        if(icmsRequestEntity.getRequestType()==HttpMethod.GET){
            responseEntity = callGet(url, icmsRequestEntity);
        }else if(icmsRequestEntity.getRequestType()==HttpMethod.POST){
            responseEntity =callPost(url, icmsRequestEntity);
        }else if(icmsRequestEntity.getRequestType()==HttpMethod.DELETE){
            responseEntity =callDelete(url, icmsRequestEntity);
        }
        assert responseEntity != null;
        return responseEntity;
    }

    private <T> Mono<ResponseEntity<T>> callGet(String url, ICMSRequestEntity icmsRequestEntity) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).path("/products");
        Map<String, String> queryParams = icmsRequestEntity.getQueryParams();
        if (queryParams != null) {
            queryParams.forEach(builder::queryParam);
        }
        Map<String, String> pathVariables = icmsRequestEntity.getPathVariables();
        if(pathVariables != null){
            builder.buildAndExpand(pathVariables).toUri();
        }
        URI uri = builder.build().toUri();
        return webClientBuilder.build()
                .get()
                .uri(uri)
               //.headers(httpHeaders -> icmsRequestEntity.getHeaders().forEach((k, v) -> httpHeaders.add((String) k, (String) v)))
                .exchangeToMono(res ->
                res.bodyToMono(icmsRequestEntity.getResponseType())
                        .map(body -> ResponseEntity.status(res.statusCode()).body(body))
        );

    }



    private <T> Mono<ResponseEntity<T>> callPost(String url, ICMSRequestEntity icmsRequestEntity) {
        return null;
    }
    private <T> Mono<ResponseEntity<T>> callDelete(String url, ICMSRequestEntity icmsRequestEntity) {
        return null;
    }

}
