package com.example.ovabackend.repository;

import com.example.ovabackend.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    List<Module> findByOvaIdOrderByOrdenAsc(Long ovaId);
}
