package com.example.ovabackend.controller;

import com.example.ovabackend.model.Asset;
import com.example.ovabackend.service.AssetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @GetMapping
    public ResponseEntity<List<Asset>> getAllAssets() {
        return ResponseEntity.ok(assetService.getAllAssets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asset> getAssetById(@PathVariable Long id) {
        return assetService.getAssetById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/lesson/{lessonId}")
    public ResponseEntity<List<Asset>> getAssetsByLessonId(@PathVariable Long lessonId) {
        return ResponseEntity.ok(assetService.getAssetsByLessonId(lessonId));
    }

    @GetMapping("/type/{tipo}")
    public ResponseEntity<List<Asset>> getAssetsByType(@PathVariable Asset.AssetType tipo) {
        return ResponseEntity.ok(assetService.getAssetsByType(tipo));
    }

    @PostMapping("/lesson/{lessonId}")
    public ResponseEntity<Asset> createAsset(@PathVariable Long lessonId, @Valid @RequestBody Asset asset) {
        return ResponseEntity.ok(assetService.createAsset(lessonId, asset));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asset> updateAsset(@PathVariable Long id, @Valid @RequestBody Asset assetDetails) {
        return ResponseEntity.ok(assetService.updateAsset(id, assetDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsset(@PathVariable Long id) {
        assetService.deleteAsset(id);
        return ResponseEntity.noContent().build();
    }
}
