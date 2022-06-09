package com.sparta.bemin.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestaurantDto {

        private String name;
        private Long minOrderPrice;
        private Long deliveryFee;

}
