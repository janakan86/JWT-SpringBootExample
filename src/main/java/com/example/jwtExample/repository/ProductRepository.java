package com.example.jwtExample.repository;

import com.example.jwtExample.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {

}
