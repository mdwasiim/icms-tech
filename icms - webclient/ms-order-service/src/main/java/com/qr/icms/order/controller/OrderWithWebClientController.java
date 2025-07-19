package com.qr.icms.order.controller;

import com.qr.icms.common.message.ICMSRequestEntity;
import com.qr.icms.common.webclient.WebClientService;
import com.qr.icms.order.Client.ProductServiceClient;
import com.qr.icms.order.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientSsl;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/orders/webclient")
public class OrderWithWebClientController {




    private final WebClientService webClientService;

    @Autowired
    public OrderWithWebClientController(WebClientService webClientService) {
        this.webClientService = webClientService;
    }

    @GetMapping("/{productId}")
    public String createOrder(@PathVariable String productId) {
        HashMap<String, String> pathVar = new HashMap<>();
        pathVar.put("id","1");
        ICMSRequestEntity icmsRequestEntity = new ICMSRequestEntity("ms-product-service", HttpMethod.GET, pathVar, null, null, null, String.class);
        Mono<ResponseEntity<String>> response = webClientService.call(icmsRequestEntity);

        ResponseEntity<String> block = response.block();
        HttpStatusCode statusCode = block.getStatusCode();
        String body = block.getBody();

        return statusCode.toString() +" Order created for product: " + body + " with price: $" ;
    }
}