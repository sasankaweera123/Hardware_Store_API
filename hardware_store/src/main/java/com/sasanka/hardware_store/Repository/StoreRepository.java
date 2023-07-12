package com.sasanka.hardware_store.Repository;

import com.sasanka.hardware_store.Document.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StoreRepository extends MongoRepository<Store, String> {

    Optional<Store> findByStoreId(String s);
}
