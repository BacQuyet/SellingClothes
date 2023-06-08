package com.example.SellingClothes.repository;

import com.example.SellingClothes.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
