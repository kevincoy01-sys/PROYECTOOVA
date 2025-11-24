package com.example.ovabackend.repository;

import com.example.ovabackend.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByOvaIdOrderByFechaCreacionDesc(Long ovaId);
    Optional<Rating> findByOvaIdAndUserId(Long ovaId, Long userId);
    
    @Query("SELECT AVG(r.calificacion) FROM Rating r WHERE r.ova.id = :ovaId")
    Double getAverageRatingByOvaId(Long ovaId);
}
