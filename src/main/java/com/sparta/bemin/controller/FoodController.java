package com.sparta.bemin.controller;

import com.sparta.bemin.dto.FoodDto;
import com.sparta.bemin.dto.RestaurantDto;
import com.sparta.bemin.models.Food;
import com.sparta.bemin.models.Restaurant;
import com.sparta.bemin.repository.FoodRepository;
import com.sparta.bemin.repository.RestaurantRepository;
import com.sparta.bemin.service.FoodService;
import com.sparta.bemin.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class FoodController {

    private final FoodService foodService;
    private final FoodRepository foodRepository;

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void createRestaurant(@PathVariable Long restaurantId, @RequestBody FoodDto requestDto) {
        foodService.postFood(restaurantId,requestDto);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFood(@PathVariable Long restaurantId) {
        return foodService.getFood(restaurantId);
    }


}
