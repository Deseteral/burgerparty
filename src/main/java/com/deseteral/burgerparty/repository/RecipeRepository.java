package com.deseteral.burgerparty.repository;

import com.deseteral.burgerparty.domain.Recipe;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, String> {

    @Query("{'category': ?0}")
    List<Recipe> findWithCategoryId(String categoryId);
}
