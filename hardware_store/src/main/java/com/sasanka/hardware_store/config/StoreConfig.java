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

            for (int i = 1; i < 20; i++) {
                storeId.add("S" + String.format("%04d", i));
            }

            store.add(new Store(storeId.get(0),"Alphtronic technology","https://maps.app.goo.gl/FVJZPMw7Pfrn4KPAA"));
            store.add(new Store(storeId.get(1),"ATOM Electronics","https://maps.app.goo.gl/YAxK2Z5d6FXM4C39A"));
            store.add(new Store(storeId.get(2),"Tronic.lk","https://maps.app.goo.gl/WtTFLMCfZMsmdd9w8"));
            store.add(new Store(storeId.get(3),"Lankatronics","https://maps.app.goo.gl/mUKCoRMUcy2aTFnS7"));
            store.add(new Store(storeId.get(4),"NC Electronics","https://maps.app.goo.gl/D6bwJinnoBFupxe39"));
            store.add(new Store(storeId.get(5),"Microchip Solutions","https://maps.app.goo.gl/Gj1kcSscdhBUQ7619"));
            store.add(new Store(storeId.get(6),"Sigma Electronics","https://maps.app.goo.gl/JwMrCttneLLB1wQc6"));
            store.add(new Store(storeId.get(7),"Digital Electronics","https://maps.app.goo.gl/69DtZUggHKwVyKXF8"));
            store.add(new Store(storeId.get(8),"Senith Electronics","https://maps.app.goo.gl/C7ZgvxfQWHPN6T4c8"));
            store.add(new Store(storeId.get(9),"Scion Electronics","https://maps.app.goo.gl/JJ1qVnfRumKJRrz38"));
            store.add(new Store(storeId.get(10),"Sena Electronics","https://maps.app.goo.gl/EVmHjQ1MvcJGF34aA"));
            store.add(new Store(storeId.get(11),"Maharagama Electricals","https://maps.app.goo.gl/wmxejixDcQ6eye3S9"));
            store.add(new Store(storeId.get(12),"Nilambara Electronics","https://maps.app.goo.gl/dQVGRP3ZYTEUsbcp7"));
            store.add(new Store(storeId.get(13),"Jinadasa Electronics & Electrical Stores","https://maps.app.goo.gl/ddGqRKkuvZV6TVMUA"));
            store.add(new Store(storeId.get(14),"Yasiru Electronics","https://maps.app.goo.gl/Xx7BoiP4p7KwxgaEA"));

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
