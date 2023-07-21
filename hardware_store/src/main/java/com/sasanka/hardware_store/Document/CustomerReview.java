package com.sasanka.hardware_store.Document;

import com.sasanka.hardware_store.Enumeration.ReviewType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CustomerReview {

    @Id
    private String id;
    @Indexed(unique = true)
    private String reviewId;
    private String customerName;
    private String review;
    private ReviewType reviewType;
    private int rating;
    private String componentId;
    private String storeId;

    public CustomerReview(String reviewId, String customerName, String review, ReviewType reviewType, int rating, String componentId, String storeId) {
        this.reviewId = reviewId;
        this.customerName = customerName;
        this.review = review;
        this.reviewType = reviewType;
        this.rating = rating;
        this.componentId = componentId;
        this.storeId = storeId;
    }
}
