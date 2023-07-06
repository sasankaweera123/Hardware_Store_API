package com.sasanka.hardware_store.controller;

import com.sasanka.hardware_store.Document.Component;
import com.sasanka.hardware_store.Service.ComponentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/component")
@AllArgsConstructor
public class ComponentController {

    private final ComponentService componentService;

    @GetMapping("/all")
    public List<Component> getAllComponents() {
        return componentService.getAllComponents();
    }

    @GetMapping(path = "{componentId}")
    public Component getComponentById(@PathVariable("componentId") String componentId) {
        return componentService.getComponentById(componentId);
    }

    @PostMapping
    public void addNewComponent(@RequestBody Component component) {
        componentService.addNewComponent(component);
    }

    @DeleteMapping(path = "{componentId}")
    public void deleteComponentById(@PathVariable("componentId") String componentId) {
        componentService.deleteComponentById(componentId);
    }

    @PutMapping(path = "{componentId}")
    public void updateComponentById(@PathVariable("componentId") String componentId,
                                    @RequestBody Component component) {
        componentService.updateComponentById(componentId, component);
    }

}
