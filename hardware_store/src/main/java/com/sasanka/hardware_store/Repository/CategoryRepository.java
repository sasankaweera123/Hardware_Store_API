package com.sasanka.hardware_store.Repository;

import com.sasanka.hardware_store.Document.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category, String> {
    Optional<Category> findByCategoryId(String s);
}
