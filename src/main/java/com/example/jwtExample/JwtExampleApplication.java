package com.example.jwtExample;

import com.example.jwtExample.domain.Product;
import com.example.jwtExample.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtExampleApplication implements CommandLineRunner {

	ProductRepository productRepository;

	JwtExampleApplication(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	private static final Logger logger = LoggerFactory.getLogger(
			JwtExampleApplication.class
	);

	public static void main(String[] args) {
		SpringApplication.run(JwtExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Product productOne = new Product("product1",10.0,"the first product");
		Product productTwo = new Product("product2",13.0,"the second product");

		productRepository.save(productOne);
		productRepository.save(productTwo);

		for (Product product : productRepository.findAll()) {
			logger.info("name: {}, description: {}",
					product.getProductName(), product.getDescription());
		}



	}
}
