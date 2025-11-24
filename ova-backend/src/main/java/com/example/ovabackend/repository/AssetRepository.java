package com.example.ovabackend.repository;

import com.example.ovabackend.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
    List<Asset> findByLessonId(Long lessonId);
    List<Asset> findByTipo(Asset.AssetType tipo);
}
