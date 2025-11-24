package com.example.ovabackend.service;

import com.example.ovabackend.model.Ova;
import com.example.ovabackend.model.Rating;
import com.example.ovabackend.model.User;
import com.example.ovabackend.repository.OvaRepository;
import com.example.ovabackend.repository.RatingRepository;
import com.example.ovabackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private OvaRepository ovaRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> getRatingById(Long id) {
        return ratingRepository.findById(id);
    }

    public List<Rating> getRatingsByOvaId(Long ovaId) {
        return ratingRepository.findByOvaIdOrderByFechaCreacionDesc(ovaId);
    }

    public Double getAverageRatingByOvaId(Long ovaId) {
        Double average = ratingRepository.getAverageRatingByOvaId(ovaId);
        return average != null ? average : 0.0;
    }

    public Rating createRating(Long ovaId, Long userId, Rating rating) {
        Ova ova = ovaRepository.findById(ovaId)
                .orElseThrow(() -> new RuntimeException("OVA no encontrado con id: " + ovaId));
        
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + userId));

        // Check if user already rated this OVA
        Optional<Rating> existingRating = ratingRepository.findByOvaIdAndUserId(ovaId, userId);
        if (existingRating.isPresent()) {
            throw new RuntimeException("El usuario ya ha calificado este OVA");
        }

        rating.setOva(ova);
        rating.setUser(user);
        return ratingRepository.save(rating);
    }

    public Rating updateRating(Long id, Rating ratingDetails) {
        Rating rating = ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calificación no encontrada con id: " + id));

        rating.setCalificacion(ratingDetails.getCalificacion());
        rating.setComentario(ratingDetails.getComentario());

        return ratingRepository.save(rating);
    }

    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }
}
