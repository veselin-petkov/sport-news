package com.example.sportnews.repositories;

import com.example.sportnews.repositories.models.CategoryDAO;

import java.util.List;

public interface CategoryRepository {
    CategoryDAO getCategory(String category);

    List<CategoryDAO> listCategories(int page, int pageSize);

    CategoryDAO crateCategory(String category);

    void deleteCategory(String category);
}
