package com.deseteral.burgerparty.service;

import com.deseteral.burgerparty.web.KeyNotFoundException;
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

    public Category add(Category category) {
        return repository.save(
            Category.builder(category).build()
        );
    }

    public Category update(Category category) {
        if (repository.findOne(category.getId()) == null) {
            throw new KeyNotFoundException("Key not found");
        }

        return repository.save(
            Category.builder(category).build()
        );
    }
}
