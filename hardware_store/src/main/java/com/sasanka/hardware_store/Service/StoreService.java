package com.sasanka.hardware_store.Service;

import com.sasanka.hardware_store.Document.Store;
import com.sasanka.hardware_store.Repository.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public void deleteStoreById(String storeId) {
        boolean exists = storeRepository.findByStoreId(storeId).isPresent();
        if (!exists){
            throw new IllegalStateException("Store with id " + storeId + " does not exist");
        }
        storeRepository.deleteById(storeId);
    }

    public Store getStoreById(String storeId) {
        return storeRepository.findByStoreId(storeId).orElseThrow(() -> new IllegalStateException("Store with id " + storeId + " does not exist"));
    }

    public void addNewStore(Store store) {
        boolean exists = storeRepository.findByStoreId(store.getStoreId()).isPresent();
        if (exists){
            throw new IllegalStateException("Store with id " + store.getStoreId() + " already exists");
        }
        storeRepository.save(store);
    }

    public void updateStoreById(String storeId, Store store) {
        boolean exists = storeRepository.findByStoreId(storeId).isPresent();
        if (!exists){
            throw new IllegalStateException("Store with id " + storeId + " does not exist");
        }
        if(store.getStoreId() != null && store.getStoreId().length() > 0 && !store.getStoreId().equals(storeId)){
            throw new IllegalStateException("Store id cannot be changed");
        }
        storeRepository.save(store);
    }
}
