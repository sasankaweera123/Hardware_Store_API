package com.sasanka.hardware_store.Document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
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
    private String category;
    private String imageUrl;
    private List<String> connect;
    private List<String> theory;
    private List<String> features;
    private List<String> statistics;

    public Component(String componentId, String name, String description, String category, String imageUrl, List<String> connect, List<String> theory, List<String> features, List<String> statistics) {
        this.componentId = componentId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.imageUrl = imageUrl;
        this.connect = connect;
        this.theory = theory;
        this.features = features;
        this.statistics = statistics;
    }
}
