package com.sasanka.hardware_store.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sasanka.hardware_store.Service.CategoryService;
import com.sasanka.hardware_store.Document.Category;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(path = "{categoryId}")
    public Category getCategoryById(@PathVariable("categoryId") String categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

}
