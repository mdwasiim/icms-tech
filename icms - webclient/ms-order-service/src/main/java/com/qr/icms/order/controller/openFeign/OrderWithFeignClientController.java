package com.qr.icms.order.controller.openFeign;

import com.qr.icms.order.Client.ProductServiceClient;
import com.qr.icms.order.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders/open-feign")
public class OrderWithFeignClientController {


    private final ProductServiceClient productServiceClient;

    public OrderWithFeignClientController(ProductServiceClient productServiceClient) {
        this.productServiceClient = productServiceClient;
    }

    @GetMapping("/{productId}")
    public String createOrder(@PathVariable String productId) {
        Product product = productServiceClient.getProductById(productId);
        return "Order created for product: " + product.getName() + " with price: $" + product.getPrice();
    }
}