package com.example.jwtExample.service;


import com.example.jwtExample.domain.Product;
import com.example.jwtExample.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }

}
