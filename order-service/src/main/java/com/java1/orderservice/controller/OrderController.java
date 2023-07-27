package com.java1.orderservice.controller;

import com.java1.orderservice.dto.OrderRequest;
import com.java1.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderservice;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderservice.placeOrder(orderRequest);
        return "Order Placed Successfully";
    }
}
