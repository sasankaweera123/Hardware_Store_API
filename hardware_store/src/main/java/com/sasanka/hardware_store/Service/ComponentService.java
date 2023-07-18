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
        if(component.getComponentId().length()!=5) {
            throw new IllegalStateException("Component id must be 5 characters long");
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
        Component existingComponent = componentRepository.findByComponentId(componentId).orElseThrow(() -> new IllegalStateException("Component with id " + componentId + " does not exist"));
        if(component.getName() != null && component.getName().length() > 0)
            existingComponent.setName(component.getName());
        if(component.getDescription() != null && component.getDescription().length() > 0)
            existingComponent.setDescription(component.getDescription());
        if(component.getImageUrl() != null && component.getImageUrl().length() > 0)
            existingComponent.setImageUrl(component.getImageUrl());
        if(component.getCategory()!=null)
            existingComponent.setCategory(component.getCategory());
        if(component.getConnect()!=null)
            existingComponent.setConnect(component.getConnect());
        if(component.getTheory()!=null)
            existingComponent.setTheory(component.getTheory());
        if(component.getFeatures() !=null)
            existingComponent.setFeatures(component.getFeatures());
        if(component.getStatistics() !=null)
            existingComponent.setStatistics(component.getStatistics());
        if(component.getStores()!=null)
            existingComponent.setStores(component.getStores());
        componentRepository.save(existingComponent);
    }
}
