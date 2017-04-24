package com.deseteral.burgerparty.service;

import com.deseteral.burgerparty.domain.Category;
import com.deseteral.burgerparty.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryService {
    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Iterable<Category> getAll() {
        return repository.findAll();
    }
}
