package com.deseteral.burgerparty.controller;

import com.deseteral.burgerparty.domain.Category;
import com.deseteral.burgerparty.domain.Recipe;
import com.deseteral.burgerparty.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Category> listAll() {
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity create(@Valid @RequestBody Category category) {
        Category createdCategory = service.add(category);
        return created(
            URI.create("/categories/" + createdCategory.getId())
        ).body(createdCategory);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable(value = "id") String id,
                                 @Valid @RequestBody Category category) {
        Category updatedCategory = service.update(
            Category.builder(category).withId(id).build()
        );

        return accepted().body(updatedCategory);
    }
}
