package com.example.sportnews.core;


import com.example.sportnews.core.models.Category;
import com.example.sportnews.repositories.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public Category getCategory(String category){
        return Mappers.fromCategoryDAO(categoryRepository.getCategory(category));
    }

    public List<Category> listCategories(int page, int pageSize){
        return categoryRepository.listCategories(page, pageSize)
                .stream()
                .map(Mappers::fromCategoryDAO)
                .collect(Collectors.toList());
    }

    public Category crateCategory(String category){
        return Mappers.fromCategoryDAO(categoryRepository.crateCategory(category));

    }

    public void deleteCategory(String category){
        categoryRepository.deleteCategory(category);
    }

}
