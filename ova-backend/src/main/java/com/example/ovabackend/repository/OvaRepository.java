package com.example.ovabackend.repository;

import com.example.ovabackend.model.Ova;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OvaRepository extends JpaRepository<Ova, Long> {
}
