package com.shoppingapp.productservice.controller;

import com.shoppingapp.productservice.dto.ProductRequest;
import com.shoppingapp.productservice.model.Product;
import com.shoppingapp.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/createProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }


    @GetMapping("/read")
    public String func(){
        return "hello pavan";
    }

}
