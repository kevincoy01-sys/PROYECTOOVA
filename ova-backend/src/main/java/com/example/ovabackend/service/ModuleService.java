package com.example.ovabackend.service;

import com.example.ovabackend.model.Module;
import com.example.ovabackend.model.Ova;
import com.example.ovabackend.repository.ModuleRepository;
import com.example.ovabackend.repository.OvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private OvaRepository ovaRepository;

    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    public Optional<Module> getModuleById(Long id) {
        return moduleRepository.findById(id);
    }

    public List<Module> getModulesByOvaId(Long ovaId) {
        return moduleRepository.findByOvaIdOrderByOrdenAsc(ovaId);
    }

    public Module createModule(Long ovaId, Module module) {
        Ova ova = ovaRepository.findById(ovaId)
                .orElseThrow(() -> new RuntimeException("OVA no encontrado con id: " + ovaId));
        
        module.setOva(ova);
        return moduleRepository.save(module);
    }

    public Module updateModule(Long id, Module moduleDetails) {
        Module module = moduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Módulo no encontrado con id: " + id));

        module.setTitulo(moduleDetails.getTitulo());
        module.setDescripcion(moduleDetails.getDescripcion());
        module.setOrden(moduleDetails.getOrden());

        return moduleRepository.save(module);
    }

    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}
