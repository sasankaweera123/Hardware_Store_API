package com.sasanka.hardware_store.controller;

import com.sasanka.hardware_store.model.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sasanka.hardware_store.Service.CategoryService;
import static org.springframework.http.HttpStatus.OK;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<Response> getAllCategories() {

        return ResponseEntity.ok(Response.builder()
                .timestamp(java.time.LocalDateTime.now())
                .statusCode(200)
                .status(OK)
                .message("Categories fetched successfully")
                .data(Map.of("categories", categoryService.getAllCategories()))
                .build());
    }

    @GetMapping(path = "{categoryId}")
    public ResponseEntity<Response> getCategoryById(@PathVariable("categoryId") String categoryId) {
        return ResponseEntity.ok(Response.builder()
                .timestamp(java.time.LocalDateTime.now())
                .statusCode(200)
                .status(OK)
                .message("Category fetched successfully")
                .data(Map.of("category", categoryService.getCategoryById(categoryId)))
                .build());
    }

}
