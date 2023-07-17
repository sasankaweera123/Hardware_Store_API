//package com.sasanka.hardware_store.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .authorizeRequests(authorizeRequests ->
//                        {
//                            authorizeRequests.requestMatchers("/api/v1/category/all").permitAll();
//                            authorizeRequests.requestMatchers("/api/v1/category/{categoryId}").permitAll();
//                            authorizeRequests.requestMatchers("/api/v1/store/all").permitAll();
//                            authorizeRequests.requestMatchers("/api/v1/store/{storeId}").permitAll();
//                            authorizeRequests.requestMatchers("/api/v1/component/all").permitAll();
//                            authorizeRequests.requestMatchers("/api/v1/component/{componentId}").permitAll();
//                            authorizeRequests.anyRequest().authenticated();
//                        })
//                .oauth2Login(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults())
//                .build();
//    }
//
//}
