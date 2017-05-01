package com.deseteral.burgerparty.controller;

import com.deseteral.burgerparty.domain.Product;
import com.deseteral.burgerparty.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.created;

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

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Product findOne(@PathVariable(value = "id") String id) {
        return service.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity create(@Valid @RequestBody Product product) {
        Product createdProduct = service.add(product);
        return created(
            URI.create("/products/" + createdProduct.getId())
        ).body(createdProduct);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable(value = "id") String id,
                                 @Valid @RequestBody Product product) {
        Product updatedProduct = service.update(
            Product.builder(product).withId(id).build()
        );

        return accepted().body(updatedProduct);
    }

    // TODO: add delete method
}
