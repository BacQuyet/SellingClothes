package com.example.SellingClothes.service;

import com.example.SellingClothes.dto.ProductDto;
import com.example.SellingClothes.entity.Orders;
import com.example.SellingClothes.entity.Products;
import com.example.SellingClothes.repository.OrderRepository;
import com.example.SellingClothes.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductsService {

    @Autowired
    private ProductRepository repo;
    @Autowired
    private OrderRepository orderRepository;

    public List<Products> listAll() {
        return repo.findAll();
    }

    public void save(Products products) {
        repo.save(products);
    }

    public Products get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

    public Products create(ProductDto productDto) {
        Long orderId = productDto.getOrderId();
        Optional<Orders> findOrder = this.orderRepository.findById(orderId);
        if (!findOrder.isPresent()){
            return null;
        }
        Products p = new Products();
        p.setOrder(findOrder.get());
        p.setName(productDto.getName());
        p.setImage(productDto.getImage());
        p.setDescription(productDto.getDescription());
        p.setPrice(productDto.getPrice());
        p.setQuantity(productDto.getQuantity());
        this.repo.save(p);
        return p;
    }

    public Products update(long id, ProductDto productDto) {
        Optional<Products> finProducts = this.repo.findById(id);
        if (!finProducts.isPresent()){
            return null;
        }
        finProducts.get().setName(productDto.getName());
        finProducts.get().setImage(productDto.getImage());
        finProducts.get().setDescription(productDto.getDescription());
        finProducts.get().setPrice(productDto.getPrice());
        finProducts.get().setQuantity(productDto.getQuantity());
        this.repo.save(finProducts.get());
        return finProducts.get();
    }
}
