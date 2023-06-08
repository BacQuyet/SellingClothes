package com.example.SellingClothes.repository;

import com.example.SellingClothes.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers, Long> {
}
