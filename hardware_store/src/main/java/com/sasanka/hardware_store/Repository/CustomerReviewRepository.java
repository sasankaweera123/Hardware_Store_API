package com.sasanka.hardware_store.Repository;

import com.sasanka.hardware_store.Document.CustomerReview;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerReviewRepository extends MongoRepository<CustomerReview,String>{

    Optional<CustomerReview> findByReviewId(String s);
}
