package com.example.ovabackend.controller;

import com.example.ovabackend.model.Ova;
import com.example.ovabackend.service.OvaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ovas")
public class OvaController {

    @Autowired
    private OvaService ovaService;

    @GetMapping
    public ResponseEntity<List<Ova>> getAllOvas() {
        return ResponseEntity.ok(ovaService.getAllOvas());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Ova>> searchOvas(@RequestParam String query) {
        return ResponseEntity.ok(ovaService.searchOvas(query));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ova> getOvaById(@PathVariable Long id) {
        Optional<Ova> ova = ovaService.getOvaById(id);
        return ova.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ova> createOva(@Valid @RequestBody Ova ova) {
        return ResponseEntity.ok(ovaService.createOva(ova));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ova> updateOva(@PathVariable Long id, @Valid @RequestBody Ova ovaDetails) {
        Ova updatedOva = ovaService.updateOva(id, ovaDetails);
        if (updatedOva != null) {
            return ResponseEntity.ok(updatedOva);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOva(@PathVariable Long id) {
        ovaService.deleteOva(id);
        return ResponseEntity.noContent().build();
    }
}
