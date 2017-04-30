package com.deseteral.burgerparty.service;

import com.deseteral.burgerparty.domain.Product;
import com.deseteral.burgerparty.domain.ProductAmount;
import com.deseteral.burgerparty.domain.Recipe;
import com.deseteral.burgerparty.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class RecipeService {
    private final RecipeRepository repository;
    private final ProductService productService;

    @Autowired
    public RecipeService(RecipeRepository repository, ProductService productService) {
        this.repository = repository;
        this.productService = productService;
    }

    public Iterable<Recipe> getAll() {
        Iterable<Recipe> recipes = repository.findAll();

        return StreamSupport
            .stream(recipes.spliterator(), false)
            .map(this::recipeWithCostAndEnergy)
            .collect(Collectors.toList());
    }

    public Iterable<Recipe> getWithCategoryId(String categoryId) {
        Iterable<Recipe> recipes = repository.findWithCategoryId(categoryId);

        return StreamSupport
            .stream(recipes.spliterator(), false)
            .map(this::recipeWithCostAndEnergy)
            .collect(Collectors.toList());
    }

    private Recipe recipeWithCostAndEnergy(Recipe recipe) {
        Double cost = calculateTotalProductCost(recipe);
        Integer energy = calculateEnergy(recipe);

        return Recipe.builder(recipe)
            .withCost(cost)
            .withEnergy(energy)
            .build();
    }

    private Double calculateTotalProductCost(Recipe recipe) {
        return recipe.getProducts().stream()
            .map(ProductAmount::getProduct)
            .map(productService::getById)
            .map(Product::getPrice)
            .reduce(0.0, (sum, productCost) -> sum += productCost);
    }

    private Integer calculateEnergy(Recipe recipe) {
        return recipe.getProducts().stream()
            .map(pa -> Pair.of(pa.getProduct(), pa.getAmount()))
            .map(p -> Pair.of(productService.getById(p.getFirst()), p.getSecond()))
            .map(p -> Pair.of(p.getFirst().getEnergy(), p.getSecond()))
            .map(p -> p.getFirst() * p.getSecond())
            .map(Math::ceil)
            .map(Double::intValue)
            .reduce(0, (sum, productEnergy) -> sum += productEnergy);
    }
}
