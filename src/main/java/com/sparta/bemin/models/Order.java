package com.sparta.bemin.models;

import com.sparta.bemin.dto.OrderDto;
import com.sparta.bemin.dto.RestaurantDto;
import com.sparta.bemin.repository.RestaurantRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Getter
@NoArgsConstructor
@Entity
public class Order {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long restaurantId;

    @Column(nullable = false)
    private Long foodId;

    @Column(nullable = false)
    private Long quantity;

    public Order(OrderDto requestDto) {
        this.restaurantId = requestDto.getRestaurantId();
        this.foodId = requestDto.getId();
        this.quantity = requestDto.getQuantity();
    }
}
