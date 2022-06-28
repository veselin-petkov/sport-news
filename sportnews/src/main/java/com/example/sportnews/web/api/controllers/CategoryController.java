package com.example.sportnews.web.api.controllers;


import com.example.sportnews.core.CategoryService;
import com.example.sportnews.core.models.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static com.example.sportnews.web.api.controllers.TokenUtil.getRoleFromToken;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/category")
@Controller
public class CategoryController {

    public CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{category}")
    public ResponseEntity<Category> getCategory(String category){
        try {
            Category category1 = categoryService.getCategory(category);
            return new ResponseEntity<Category>(category1, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping
    public List<Category> listNewsByCategory(){
        return categoryService.listCategories(0,10);
    }


    @PostMapping("/add")
    public void add(@RequestBody Category category, @RequestHeader("Authorization") String token) {
        int roleID = getRoleFromToken(token);
        if (roleID==2){
            categoryService.crateCategory(category.category);
        } else {
            throw new AccessDeniedException("403");
        }
    }


    @DeleteMapping("/delete/{category}")
    public void deleteComment(@PathVariable String category){
        categoryService.deleteCategory(category);
    }

}
