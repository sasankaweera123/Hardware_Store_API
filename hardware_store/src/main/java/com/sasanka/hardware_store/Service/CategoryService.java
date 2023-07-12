package com.sasanka.hardware_store.Service;

import com.sasanka.hardware_store.Document.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.sasanka.hardware_store.Repository.CategoryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void deleteCategoryById(String categoryId) {
        boolean exists = categoryRepository.findByCategoryId(categoryId).isPresent();
        if (!exists){
            throw new IllegalStateException("Category with id " + categoryId + " does not exist");
        }
        categoryRepository.deleteById(categoryId);
    }

    public Category getCategoryById(String categoryId) {
        return categoryRepository.findByCategoryId(categoryId).orElseThrow(() -> new IllegalStateException("Category with id " + categoryId + " does not exist"));
    }

    public void addNewCategory(Category category) {
        boolean exists = categoryRepository.findByCategoryId(category.getCategoryId()).isPresent();
        if (exists){
            throw new IllegalStateException("Category with id " + category.getCategoryId() + " already exists");
        }
        categoryRepository.save(category);
    }

    public void updateCategoryById(String categoryId, Category category) {
        boolean exists = categoryRepository.findByCategoryId(categoryId).isPresent();
        if (!exists){
            throw new IllegalStateException("Category with id " + categoryId + " does not exist");
        }
        if(category.getCategoryId() != null && category.getCategoryId().length() > 0 && !category.getCategoryId().equals(categoryId)){
            throw new IllegalStateException("Category id cannot be changed");
        }
        categoryRepository.save(category);
    }
}
