package com.example.ovabackend.service;

import com.example.ovabackend.model.Asset;
import com.example.ovabackend.model.Lesson;
import com.example.ovabackend.repository.AssetRepository;
import com.example.ovabackend.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private LessonRepository lessonRepository;

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public Optional<Asset> getAssetById(Long id) {
        return assetRepository.findById(id);
    }

    public List<Asset> getAssetsByLessonId(Long lessonId) {
        return assetRepository.findByLessonId(lessonId);
    }

    public List<Asset> getAssetsByType(Asset.AssetType tipo) {
        return assetRepository.findByTipo(tipo);
    }

    public Asset createAsset(Long lessonId, Asset asset) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lección no encontrada con id: " + lessonId));
        
        asset.setLesson(lesson);
        return assetRepository.save(asset);
    }

    public Asset updateAsset(Long id, Asset assetDetails) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset no encontrado con id: " + id));

        asset.setNombre(assetDetails.getNombre());
        asset.setTipo(assetDetails.getTipo());
        asset.setUrl(assetDetails.getUrl());
        asset.setDescripcion(assetDetails.getDescripcion());

        return assetRepository.save(asset);
    }

    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }
}
