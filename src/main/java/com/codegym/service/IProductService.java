package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.model.Product;

import java.util.Optional;

public interface IProductService extends IGeneralService<Product> {
    Optional<Product> findAllByNameContaining(String name);
    Iterable<Product> findAllByCategory (Category category);
}
