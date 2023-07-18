package com.sasanka.hardware_store.Service;

import com.sasanka.hardware_store.Document.CustomerReview;
import com.sasanka.hardware_store.Repository.CustomerReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerReviewService {

    private final CustomerReviewRepository customerReviewRepository;

    public List<CustomerReview> getAllCustomerReviews(){
        return customerReviewRepository.findAll();
    }

    public CustomerReview getCustomerReviewById(String reviewId){
        return customerReviewRepository.findByReviewId(reviewId).orElseThrow(() -> new IllegalStateException("Customer Review with id " + reviewId + " does not exist"));
    }

    public void deleteCustomerReviewById(String reviewId){
        boolean exists = customerReviewRepository.findByReviewId(reviewId).isPresent();
        if (!exists){
            throw new IllegalStateException("Customer Review with id " + reviewId + " does not exist");
        }
        customerReviewRepository.deleteById(reviewId);
    }

    public void addNewCustomerReview(CustomerReview customerReview){
        boolean exists = customerReviewRepository.findByReviewId(customerReview.getReviewId()).isPresent();
        if (exists){
            throw new IllegalStateException("Customer Review with id " + customerReview.getReviewId() + " already exists");
        }
        if(customerReview.getReviewId().length()!=5) {
            throw new IllegalStateException("Customer Review id should be 5 characters long");
        }
        customerReviewRepository.save(customerReview);
    }

    public void updateCustomerReviewById(String reviewId, CustomerReview customerReview){
        boolean exists = customerReviewRepository.findByReviewId(reviewId).isPresent();
        if (!exists){
            throw new IllegalStateException("Customer Review with id " + reviewId + " does not exist");
        }
        if(customerReview.getReviewId() != null && customerReview.getReviewId().length() > 0 && !customerReview.getReviewId().equals(reviewId)){
            throw new IllegalStateException("Customer Review id cannot be changed");
        }
        CustomerReview existingCustomerReview = customerReviewRepository.findByReviewId(reviewId).orElseThrow(() -> new IllegalStateException("Customer Review with id " + reviewId + " does not exist"));
        if(customerReview.getCustomerName() != null && customerReview.getCustomerName().length() > 0)
            existingCustomerReview.setCustomerName(customerReview.getCustomerName());
        if(customerReview.getReview() != null && customerReview.getReview().length() > 0)
            existingCustomerReview.setReview(customerReview.getReview());
        if(customerReview.getRating() > 0)
            existingCustomerReview.setRating(customerReview.getRating());
        if(customerReview.getReviewType() != null)
            existingCustomerReview.setReviewType(customerReview.getReviewType());
        if(customerReview.getComponentId() != null)
            existingCustomerReview.setComponentId(customerReview.getComponentId());
        if(customerReview.getStoreId() != null)
            existingCustomerReview.setStoreId(customerReview.getStoreId());

        customerReviewRepository.save(existingCustomerReview);
    }

}
