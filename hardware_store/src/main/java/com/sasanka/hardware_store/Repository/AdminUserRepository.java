package com.sasanka.hardware_store.Repository;

import com.sasanka.hardware_store.Document.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AdminUserRepository extends MongoRepository<Admin,String> {

    Admin findByUsername(String s);
}
