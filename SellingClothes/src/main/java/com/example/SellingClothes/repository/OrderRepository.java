package com.example.SellingClothes.repository;

import com.example.SellingClothes.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
