package com.deseteral.burgerparty.service;

import com.deseteral.burgerparty.domain.Product;
import com.deseteral.burgerparty.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Iterable<Product> getAll() {
        return repository.findAll();
    }
}
