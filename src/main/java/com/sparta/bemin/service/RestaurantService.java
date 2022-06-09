package com.sparta.bemin.service;

import com.sparta.bemin.dto.RestaurantDto;
import com.sparta.bemin.models.Restaurant;
import com.sparta.bemin.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Restaurant postRestaurant(RestaurantDto requestDto) {
        Long minorderprice = requestDto.getMinOrderPrice();
        Long pee = requestDto.getDeliveryFee();
        if(minorderprice <1000 || minorderprice>100000){
            throw new RuntimeException("1000~100000원까지만 입력할 수 있습니다.");
        }
        if(!(minorderprice%100==0)){
            throw new RuntimeException("100원단위로 입력해야 합니다.");
        }
        if(pee <0 || pee >10000){
            throw new RuntimeException("0~10000원까지만 입력할 수 있습니다.");
        }
        if(!(pee%500==0)){
            throw new RuntimeException("500원단위로 입력해야 합니다.");
        }
        Restaurant restaurant = new Restaurant(requestDto);
        restaurantRepository.save(restaurant);
        return restaurant;
    }


    public List<Restaurant> getRestaurant() {
        return restaurantRepository.findAll();
    }
}
