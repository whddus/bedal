package com.sparta.bemin.controller;

import com.sparta.bemin.dto.RestaurantDto;
import com.sparta.bemin.models.Restaurant;
import com.sparta.bemin.repository.RestaurantRepository;
import com.sparta.bemin.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantRepository restaurantRepository;

    @PostMapping("/restaurant/register")
    public Restaurant createRestaurant(@RequestBody RestaurantDto requestDto) {

        return restaurantService.postRestaurant(requestDto);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant() {
        return restaurantService.getRestaurant();
    }

}
