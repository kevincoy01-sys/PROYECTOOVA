package com.example.ovabackend.repository;

import com.example.ovabackend.model.Ova;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OvaRepository extends JpaRepository<Ova, Long> {
    List<Ova> findByTituloContainingIgnoreCaseOrDescripcionContainingIgnoreCaseOrAutorContainingIgnoreCase(
        String titulo, String descripcion, String autor
    );
}
