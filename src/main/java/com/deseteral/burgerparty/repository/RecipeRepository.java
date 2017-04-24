package com.deseteral.burgerparty.repository;

import com.deseteral.burgerparty.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, String> { }
