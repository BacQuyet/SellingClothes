package com.example.SellingClothes.service;

import com.example.SellingClothes.entity.Customers;
import com.example.SellingClothes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public List<Customers> listAll() {
        return repo.findAll();
    }

    public void save(Customers customer) {
        repo.save(customer);
    }

    public Customers get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
