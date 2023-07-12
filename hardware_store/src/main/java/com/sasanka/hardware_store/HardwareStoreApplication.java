package com.sasanka.hardware_store;

import com.sasanka.hardware_store.Document.Component;
import com.sasanka.hardware_store.Repository.ComponentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.List;

@SpringBootApplication
public class HardwareStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(HardwareStoreApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("*")
						.allowedHeaders("*")
						.allowedOrigins("*");
			}
		};
	}
}
