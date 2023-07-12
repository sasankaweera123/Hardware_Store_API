package com.sasanka.hardware_store.config;

import com.sasanka.hardware_store.Document.Category;
import com.sasanka.hardware_store.Repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class CategoryConfig {

    @Bean
    CommandLineRunner CategoryRunner(CategoryRepository repository){
        return args -> {
            ArrayList<String> categoryId = new ArrayList<>();
            ArrayList<Category> categories = new ArrayList<>();

            for (int i = 1; i < 15; i++) {
                categoryId.add("K" + String.format("%04d", i));
            }

            categories.add(new Category(categoryId.get(0), "Environmental sensors"));
            categories.add(new Category(categoryId.get(1), "Motion and position sensors"));
            categories.add(new Category(categoryId.get(2), "Optical sensors"));
            categories.add(new Category(categoryId.get(3), "Communication modules"));
            categories.add(new Category(categoryId.get(4), "Input devices"));
            categories.add(new Category(categoryId.get(5), "Output devices"));
            categories.add(new Category(categoryId.get(6), "Power control modules"));
            categories.add(new Category(categoryId.get(7), "Biometric sensors"));
            categories.add(new Category(categoryId.get(8), "sensors"));
            categories.add(new Category(categoryId.get(9), "Actuators"));
            categories.add(new Category(categoryId.get(10), "Microcontrollers"));
            categories.add(new Category(categoryId.get(11), "Modules"));

            for (int i = 0; i < categories.size(); i++) {
                int finalI = i;
                repository.findByCategoryId(categoryId.get(i)).ifPresentOrElse(
                        value -> System.out.println("Category already exists "+ categoryId.get(finalI)),
                        () -> repository.insert(categories.get(finalI))
                );
            }
        };
    }
}
