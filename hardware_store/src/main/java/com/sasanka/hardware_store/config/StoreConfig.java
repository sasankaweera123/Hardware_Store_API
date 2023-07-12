package com.sasanka.hardware_store.config;

import com.sasanka.hardware_store.Document.Store;
import com.sasanka.hardware_store.Repository.StoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class StoreConfig {

    @Bean
    CommandLineRunner runnerStore(StoreRepository repository){
        return args -> {

            ArrayList<String> storeId = new ArrayList<>();
            ArrayList<Store> store = new ArrayList<>();

            for (int i = 1; i < 10; i++) {
                storeId.add("S" + String.format("%04d", i));
            }

            store.add(new Store(storeId.get(0), "Store 1"));
            store.add(new Store(storeId.get(1), "Store 2"));
            store.add(new Store(storeId.get(2), "Store 3"));
            store.add(new Store(storeId.get(3), "Store 4"));
            store.add(new Store(storeId.get(4), "Store 5"));

            for (int i = 0; i < store.size(); i++) {
                int finalI = i;
                repository.findByStoreId(storeId.get(i)).ifPresentOrElse(
                        value -> System.out.println("Store already exists "+ storeId.get(finalI)),
                        () -> repository.insert(store.get(finalI))
                );
            }
        };
    }

}
