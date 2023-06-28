package com.sasanka.hardware_store.Repository;

import com.sasanka.hardware_store.Document.Component;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ComponentRepository extends MongoRepository<Component, String> {
    Optional<Component> findByComponentId(String componentId);
}
