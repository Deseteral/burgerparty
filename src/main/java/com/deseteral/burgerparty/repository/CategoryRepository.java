package com.deseteral.burgerparty.repository;

import com.deseteral.burgerparty.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, String> { }
