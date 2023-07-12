package com.sasanka.hardware_store.Document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Component {
    @Id
    private String id;

    @Indexed(unique = true)
    private String componentId;
    private String name;
    private String description;
    private String imageUrl;
    private List<String> category;
    private List<String> connect;
    private List<String> theory;
    private List<String> features;
    private List<String> statistics;
    private List<String> stores;

    public Component(String componentId, String name, String description, String imageUrl, List<String> category, List<String> connect, List<String> theory, List<String> features, List<String> statistics, List<String> stores) {
        this.componentId = componentId;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        this.connect = connect;
        this.theory = theory;
        this.features = features;
        this.statistics = statistics;
        this.stores = stores;
    }
}
