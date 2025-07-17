package com.qr.icms.order.controller;

import com.qr.icms.order.feignClient.ProductServiceClient;
import com.qr.icms.order.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final ProductServiceClient productServiceClient;

    public OrderController(ProductServiceClient productServiceClient) {
        this.productServiceClient = productServiceClient;
    }

    @GetMapping("/{productId}")
    public String createOrder(@PathVariable String productId) {
        Product product = productServiceClient.getProductById(productId);
        return "Order created for product: " + product.getName() + " with price: $" + product.getPrice();
    }
}