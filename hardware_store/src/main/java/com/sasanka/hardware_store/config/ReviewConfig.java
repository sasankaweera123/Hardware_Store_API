package com.sasanka.hardware_store.config;

import com.sasanka.hardware_store.Document.CustomerReview;
import com.sasanka.hardware_store.Enumeration.ReviewType;
import com.sasanka.hardware_store.Repository.CustomerReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class ReviewConfig {

    @Bean
    CommandLineRunner reviewCommandLineRunner(CustomerReviewRepository repository){
        return args -> {

            ArrayList<CustomerReview> reviews = new ArrayList<>();
            ArrayList<String> reviewId = new ArrayList<>();

            for (int i = 1; i < 10; i++) {
                reviewId.add("R" + String.format("%04d", i));
            }

            reviews.add( new CustomerReview(reviewId.get(0), "R0001 Customer", "P0001", ReviewType.COMPONENT_REVIEW, 5, "C0001", ""));
            reviews.add( new CustomerReview(reviewId.get(1), "R0002 Customer", "P0002", ReviewType.STORE_REVIEW, 4, "C0002", "S0001"));

            for (int i = 0; i < reviews.size(); i++) {
                int finalI = i;
                repository.findByReviewId(reviewId.get(i)).ifPresentOrElse(
                        value -> System.out.println("Review already exists "+ reviewId.get(finalI)),
                        () -> repository.insert(reviews.get(finalI))
                );
            }

        };
    }
}
