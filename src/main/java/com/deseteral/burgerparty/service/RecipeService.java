package com.deseteral.burgerparty.service;

import com.deseteral.burgerparty.domain.Recipe;
import com.deseteral.burgerparty.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecipeService {
    private final RecipeRepository repository;

    @Autowired
    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public Iterable<Recipe> getAll() {
        return repository.findAll();
    }

    public Iterable<Recipe> getWithCategoryId(String categoryId) {
        return repository.findWithCategoryId(categoryId);
    }
}
