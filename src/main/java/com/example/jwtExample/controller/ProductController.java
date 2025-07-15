package com.example.jwtExample.controller;


import com.example.jwtExample.domain.Product;
import com.example.jwtExample.repository.ProductRepository;
import com.example.jwtExample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping("/products")
    Iterable<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/testAdminPage")
    String getAdminPage(){
        return "test admin page";
    }

}
