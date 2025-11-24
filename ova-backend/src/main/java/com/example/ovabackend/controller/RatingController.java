package com.example.ovabackend.controller;

import com.example.ovabackend.model.Rating;
import com.example.ovabackend.service.RatingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable Long id) {
        return ratingService.getRatingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ova/{ovaId}")
    public ResponseEntity<List<Rating>> getRatingsByOvaId(@PathVariable Long ovaId) {
        return ResponseEntity.ok(ratingService.getRatingsByOvaId(ovaId));
    }

    @GetMapping("/ova/{ovaId}/average")
    public ResponseEntity<Map<String, Double>> getAverageRatingByOvaId(@PathVariable Long ovaId) {
        Double average = ratingService.getAverageRatingByOvaId(ovaId);
        Map<String, Double> response = new HashMap<>();
        response.put("average", average);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/ova/{ovaId}/user/{userId}")
    public ResponseEntity<Rating> createRating(
            @PathVariable Long ovaId,
            @PathVariable Long userId,
            @Valid @RequestBody Rating rating) {
        return ResponseEntity.ok(ratingService.createRating(ovaId, userId, rating));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable Long id, @Valid @RequestBody Rating ratingDetails) {
        return ResponseEntity.ok(ratingService.updateRating(id, ratingDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
        return ResponseEntity.noContent().build();
    }
}
