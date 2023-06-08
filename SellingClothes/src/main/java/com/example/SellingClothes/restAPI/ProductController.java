package com.example.SellingClothes.restAPI;

import com.example.SellingClothes.dto.ProductDto;
import com.example.SellingClothes.entity.Products;
import com.example.SellingClothes.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products/v1/")
public class ProductController {
    @Autowired
    private ProductsService productsService;

    @CrossOrigin
    @GetMapping("/products")
    public List<Products> getALL() {
        List<Products> listProducts = productsService.listAll();
        return listProducts;
    }

    @CrossOrigin
    @GetMapping("/products/{id}")
    public Products getProductsDById(@PathVariable Long id) {
        Products p = productsService.get(id);
        return p;
    }

    @CrossOrigin
    @PostMapping("/products")
    public Products createProducts(@RequestBody ProductDto productDto) throws Exception {
        return this.productsService.create(productDto);

    }

    @CrossOrigin
    @DeleteMapping("/products/{id}")
    public String deleteProducts(@PathVariable Long id) {
        productsService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return "deleted";
    }

    @CrossOrigin
    @PutMapping("/products/{id}")
    public Products updateProducts(@PathVariable long id,@RequestBody ProductDto productDto) throws Exception {
        return this.productsService.update(id, productDto);
    }
}
