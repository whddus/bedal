package com.sparta.bemin.controller;

import com.sparta.bemin.dto.FoodDto;
import com.sparta.bemin.dto.OrderDto;
import com.sparta.bemin.models.Order;
import com.sparta.bemin.repository.OrderRepository;
import com.sparta.bemin.service.FoodService;
import com.sparta.bemin.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    private final OrderRepository orderRepository;

    @PostMapping("/order/request")
    public Order createRestaurant(@RequestBody OrderDto requestDto) {
        return orderService.order(requestDto);
    }

    @GetMapping("/order")
    public List<Order> getOrder() {
        return orderRepository.findAll();

    }

}
