package com.example.SellingClothes.restAPI;

import com.example.SellingClothes.entity.Customers;
import com.example.SellingClothes.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer/v1/")
public class CustomerController {

    @Autowired
    private CustomerService repo;

    @CrossOrigin
    @GetMapping("/customers")
    public List<Customers> getALL() {
        List<Customers> listCustomers = repo.listAll();
        return listCustomers;
    }

    @CrossOrigin
    @GetMapping("/getCusByID/{id}")
    public Customers getCusById(@PathVariable Long id) {
        Customers cus = repo.get(id);
        return cus;
    }

    @CrossOrigin
    @PostMapping("/customers")
    public Customers createCustomer(@RequestBody Customers cus) throws Exception {
        try {
            repo.save(cus);
            return repo.get(cus.getId());
        } catch( Exception e) {
            throw new Exception("Đã có");
        }
    }

    @CrossOrigin
    @DeleteMapping("/customers/{id}")
    public String  deleteCustomer(@PathVariable Long id) {
        repo.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return "deleted";
    }

    @CrossOrigin
    @PutMapping("/customers")
    public Customers updateCustomer(@RequestBody Customers prod) throws Exception {
        try {
            repo.save(prod);
            return repo.get(prod.getId());
        } catch( Exception e) {
            throw new Exception("Đã có");
        }
    }
}
