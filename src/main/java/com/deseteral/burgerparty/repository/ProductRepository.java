package com.deseteral.burgerparty.repository;

import com.deseteral.burgerparty.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> { }
