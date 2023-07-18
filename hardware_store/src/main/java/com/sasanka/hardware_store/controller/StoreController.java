package com.sasanka.hardware_store.controller;

import com.sasanka.hardware_store.Document.Store;
import com.sasanka.hardware_store.Service.StoreService;
import com.sasanka.hardware_store.model.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
@AllArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/all")
    public ResponseEntity<Response> getAllStores() {

        return ResponseEntity.ok(Response.builder()
                .timestamp(java.time.LocalDateTime.now())
                .statusCode(200)
                .status(org.springframework.http.HttpStatus.OK)
                .message("Stores fetched successfully")
                .data(java.util.Map.of("stores", storeService.getAllStores()))
                .build());
    }

    @GetMapping(path = "{storeId}")
    public ResponseEntity<Response> getStoreById(@PathVariable("storeId") String storeId) {
        return ResponseEntity.ok(Response.builder()
                .timestamp(java.time.LocalDateTime.now())
                .statusCode(200)
                .status(org.springframework.http.HttpStatus.OK)
                .message("Store fetched successfully")
                .data(java.util.Map.of("store", storeService.getStoreById(storeId)))
                .build());
    }
}
