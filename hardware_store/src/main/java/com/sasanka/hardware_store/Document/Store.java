package com.sasanka.hardware_store.Document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Store {

    @Id
    private String Id;

    @Indexed(unique = true)
    private String storeId;

    private String name;

    public Store(String storeId ,String name) {
        this.storeId = storeId;
        this.name = name;
    }
}
