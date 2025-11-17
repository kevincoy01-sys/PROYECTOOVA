package com.example.ovabackend.service;

import com.example.ovabackend.model.Ova;
import com.example.ovabackend.repository.OvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OvaService {

    @Autowired
    private OvaRepository ovaRepository;

    public List<Ova> getAllOvas() {
        return ovaRepository.findAll();
    }

    public List<Ova> searchOvas(String query) {
        return ovaRepository.findByTituloContainingIgnoreCaseOrDescripcionContainingIgnoreCaseOrAutorContainingIgnoreCase(
            query, query, query
        );
    }

    public Optional<Ova> getOvaById(Long id) {
        return ovaRepository.findById(id);
    }

    public Ova createOva(Ova ova) {
        return ovaRepository.save(ova);
    }

    public Ova updateOva(Long id, Ova ovaDetails) {
        Optional<Ova> ovaOptional = ovaRepository.findById(id);
        if (ovaOptional.isPresent()) {
            Ova ova = ovaOptional.get();
            ova.setTitulo(ovaDetails.getTitulo());
            ova.setDescripcion(ovaDetails.getDescripcion());
            ova.setAutor(ovaDetails.getAutor());
            ova.setFechaCreacion(ovaDetails.getFechaCreacion());
            return ovaRepository.save(ova);
        }
        return null;
    }

    public void deleteOva(Long id) {
        ovaRepository.deleteById(id);
    }
}
