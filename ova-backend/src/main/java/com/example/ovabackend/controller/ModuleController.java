package com.example.ovabackend.controller;

import com.example.ovabackend.model.Module;
import com.example.ovabackend.service.ModuleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @GetMapping
    public ResponseEntity<List<Module>> getAllModules() {
        return ResponseEntity.ok(moduleService.getAllModules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable Long id) {
        return moduleService.getModuleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ova/{ovaId}")
    public ResponseEntity<List<Module>> getModulesByOvaId(@PathVariable Long ovaId) {
        return ResponseEntity.ok(moduleService.getModulesByOvaId(ovaId));
    }

    @PostMapping("/ova/{ovaId}")
    public ResponseEntity<Module> createModule(@PathVariable Long ovaId, @Valid @RequestBody Module module) {
        return ResponseEntity.ok(moduleService.createModule(ovaId, module));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @Valid @RequestBody Module moduleDetails) {
        return ResponseEntity.ok(moduleService.updateModule(id, moduleDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }
}
