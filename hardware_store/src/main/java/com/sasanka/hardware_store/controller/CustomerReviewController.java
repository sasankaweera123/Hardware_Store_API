package com.sasanka.hardware_store.controller;

import com.sasanka.hardware_store.Document.CustomerReview;
import com.sasanka.hardware_store.Service.CustomerReviewService;
import com.sasanka.hardware_store.model.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/customer_review")
@AllArgsConstructor
public class CustomerReviewController {

    private final CustomerReviewService customerReviewService;

    @GetMapping("/all")
    public ResponseEntity<Response> getAllCustomerReviews(){
        return ResponseEntity.ok(Response.builder()
                .timestamp(java.time.LocalDateTime.now())
                .statusCode(200)
                .status(OK)
                .message("Customer Reviews fetched successfully")
                .data(Map.of("customer_reviews", customerReviewService.getAllCustomerReviews()))
                .build());
    }

    @GetMapping(path = "{customerReviewId}")
    public ResponseEntity<Response> getCustomerReviewById(@PathVariable("customerReviewId") String customerReviewId){
        return ResponseEntity.ok(Response.builder()
                .timestamp(java.time.LocalDateTime.now())
                .statusCode(200)
                .status(OK)
                .message("Customer Review fetched successfully")
                .data(Map.of("customer_review", customerReviewService.getCustomerReviewById(customerReviewId)))
                .build());
    }

    @PostMapping
    public ResponseEntity<Response> addNewCustomerReview(@RequestBody CustomerReview customerReview){
        customerReviewService.addNewCustomerReview(customerReview);
        return ResponseEntity.ok(Response.builder()
                .timestamp(java.time.LocalDateTime.now())
                .statusCode(200)
                .status(CREATED)
                .message("Customer Review added successfully")
                .data(Map.of("customer_review", customerReview))
                .build());
    }

    @DeleteMapping(path = "{customerReviewId}")
    public ResponseEntity<Response> deleteCustomerReviewById(@PathVariable("customerReviewId") String customerReviewId){
        customerReviewService.deleteCustomerReviewById(customerReviewId);
        return ResponseEntity.ok(Response.builder()
                .timestamp(java.time.LocalDateTime.now())
                .statusCode(200)
                .status(OK)
                .message("Customer Review deleted successfully")
                .build());
    }

    @PutMapping(path = "{customerReviewId}")
    public ResponseEntity<Response> updateCustomerReviewById(@PathVariable("customerReviewId") String customerReviewId,
                                         @RequestBody CustomerReview customerReview){
        customerReviewService.updateCustomerReviewById(customerReviewId, customerReview);
        return ResponseEntity.ok(Response.builder()
                .timestamp(java.time.LocalDateTime.now())
                .statusCode(200)
                .status(OK)
                .message("Customer Review updated successfully")
                .data(Map.of("customer_review", customerReviewService.getCustomerReviewById(customerReviewId)))
                .build());
    }
}
