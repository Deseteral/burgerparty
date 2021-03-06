package com.deseteral.burgerparty.service;

import com.deseteral.burgerparty.web.KeyNotFoundException;
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

    public Product getById(String id) {
        Product product = repository.findOne(id);

        if (product == null) {
            throw new KeyNotFoundException("Key not found");
        }

        return product;
    }

    public Product add(Product product) {
        return repository.save(
            Product.builder(product).build()
        );
    }

    public Product update(Product product) {
        if (repository.findOne(product.getId()) == null) {
            throw new KeyNotFoundException("Key not found");
        }

        return repository.save(
            Product.builder(product).build()
        );
    }
}
