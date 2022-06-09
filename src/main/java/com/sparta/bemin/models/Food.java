package com.sparta.bemin.models;


import com.sparta.bemin.dto.FoodDto;
import com.sparta.bemin.dto.RestaurantDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Food extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    //음식명은 중복될 수 없음
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Long restaurantId;

    @Column(nullable = false)
    private Long price;


    public Food(Long restaurantId,FoodDto requestDto) {
        this.name = requestDto.getName();
        this.restaurantId = restaurantId;
        this.price = requestDto.getPrice();
    }
}
