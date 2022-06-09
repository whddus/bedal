package com.sparta.bemin.dto;

import com.sparta.bemin.models.Food;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Setter
@Getter
public class OrderDto {
    private Long restaurantId;
    private Long id;//음식아이디
    private Long quantity;
}
