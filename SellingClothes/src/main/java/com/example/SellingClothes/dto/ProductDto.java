package com.example.SellingClothes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String image;
    private String description;
    private double price;
    private int quantity;
    private Long orderId;


}
