package com.sasanka.hardware_store.Service;

import com.sasanka.hardware_store.Document.Component;
import com.sasanka.hardware_store.Repository.ComponentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComponentService {

    private final ComponentRepository componentRepository;

    public List<Component> getAllComponents() {
        return componentRepository.findAll();
    }

}
