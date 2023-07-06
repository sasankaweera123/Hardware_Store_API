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

    public void deleteComponentById(String componentId) {
        boolean exists = componentRepository.findByComponentId(componentId).isPresent();
        if (!exists){
            throw new IllegalStateException("Component with id " + componentId + " does not exist");
        }
        componentRepository.deleteById(componentId);
    }

    public Component getComponentById(String componentId) {
        return componentRepository.findByComponentId(componentId).orElseThrow(() -> new IllegalStateException("Component with id " + componentId + " does not exist"));
    }

    public void addNewComponent(Component component) {
        boolean exists = componentRepository.findByComponentId(component.getComponentId()).isPresent();
        if (exists){
            throw new IllegalStateException("Component with id " + component.getComponentId() + " already exists");
        }
        componentRepository.save(component);
    }

    public void updateComponentById(String componentId, Component component) {
        boolean exists = componentRepository.findByComponentId(componentId).isPresent();
        if (!exists){
            throw new IllegalStateException("Component with id " + componentId + " does not exist");
        }
        if(component.getComponentId() != null && component.getComponentId().length() > 0 && !component.getComponentId().equals(componentId)){
            throw new IllegalStateException("Component id cannot be changed");
        }
        componentRepository.save(component);
    }
}
