package com.deseteral.burgerparty.controller;

import com.deseteral.burgerparty.domain.Recipe;
import com.deseteral.burgerparty.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.created;

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

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity create(@Valid @RequestBody Recipe recipe) {
        Recipe createdRecipe = service.add(recipe);
        return created(
            URI.create("/recipes/" + createdRecipe.getId())
        ).body(createdRecipe);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable(value = "id") String id,
                                 @Valid @RequestBody Recipe recipe) {
        Recipe updatedRecipe = service.update(
            Recipe.builder(recipe).withId(id).build()
        );

        return accepted().body(updatedRecipe);
    }

    // TODO: add delete method
}
