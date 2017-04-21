package com.deseteral.burgerparty.controller;

import com.deseteral.burgerparty.domain.Product;
import com.deseteral.burgerparty.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Product> listAll() {
        return service.getAll();
    }
}
