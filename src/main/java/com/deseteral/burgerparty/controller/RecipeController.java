package com.deseteral.burgerparty.controller;

import com.deseteral.burgerparty.domain.Recipe;
import com.deseteral.burgerparty.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService service;

    @Autowired
    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @GetMapping(params = { "!categoryId" })
    public Iterable<Recipe> listAll() {
        return service.getAll();
    }

    @GetMapping(params = { "categoryId" })
    public Iterable<Recipe> listWithCategory(@RequestParam("categoryId") String categoryId) {
        return service.getWithCategoryId(categoryId);
    }
}
