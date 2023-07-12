package com.sasanka.hardware_store.controller;

import com.sasanka.hardware_store.Document.Store;
import com.sasanka.hardware_store.Service.StoreService;
import lombok.AllArgsConstructor;
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
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping(path = "{storeId}")
    public Store getStoreById(@PathVariable("storeId") String storeId) {
        return storeService.getStoreById(storeId);
    }
}
