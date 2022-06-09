package com.sparta.bemin.service;

import com.sparta.bemin.dto.FoodDto;
import com.sparta.bemin.dto.OrderDto;
import com.sparta.bemin.models.Food;
import com.sparta.bemin.models.Order;
import com.sparta.bemin.models.Restaurant;
import com.sparta.bemin.repository.FoodRepository;
import com.sparta.bemin.repository.OrderRepository;
import com.sparta.bemin.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Order order(OrderDto requestDto) {
        Long quantity = requestDto.getQuantity();

        if(quantity <1 || quantity>100){
            throw new RuntimeException("1~100개 까지만 주문할 수 있습니다.");
        }
        Order order = new Order(requestDto);
        orderRepository.save(order);
        return order;
    }
}
