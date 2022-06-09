package com.sparta.bemin.service;


import com.sparta.bemin.dto.FoodDto;
import com.sparta.bemin.models.Food;
import com.sparta.bemin.models.Restaurant;
import com.sparta.bemin.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Transactional
    public void postFood(Long restaurantId, FoodDto requestDto) {
        Long price = requestDto.getPrice();

        if(price <100 || price>1000000){
            throw new RuntimeException("100~1000000원까지만 입력할 수 있습니다.");
        }
        if(!(price%100==0)){
            throw new RuntimeException("100원단위로 입력해야 합니다.");
        }

        Food food = new Food(restaurantId,requestDto);
        foodRepository.save(food);
    }

    public List<Food> getFood(Long restaurantId) {
        return foodRepository.findAllByRestaurantId(restaurantId);
    }

}
