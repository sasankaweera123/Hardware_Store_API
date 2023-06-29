package com.sasanka.hardware_store.controller;

import com.sasanka.hardware_store.Document.Component;
import com.sasanka.hardware_store.Service.ComponentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
