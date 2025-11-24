package com.example.ovabackend.config;

import com.example.ovabackend.model.Ova;
import com.example.ovabackend.repository.OvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private OvaRepository ovaRepository;

    @Override
    public void run(String... args) throws Exception {
        if (ovaRepository.count() == 0) {
            Ova simuladorCache = new Ova();
            simuladorCache.setTitulo("Simulador de Caché");
            simuladorCache.setDescripcion("Herramienta interactiva para visualizar y comprender el funcionamiento de diferentes políticas de reemplazo de caché (LRU, FIFO, LFU). Permite simular accesos a memoria y observar el comportamiento de la caché en tiempo real.");
            simuladorCache.setAutor("Sistema OVA");
            simuladorCache.setFechaCreacion(LocalDate.now());
            ovaRepository.save(simuladorCache);

            Ova algoritmosOrdenamiento = new Ova();
            algoritmosOrdenamiento.setTitulo("Algoritmos de Ordenamiento Visuales");
            algoritmosOrdenamiento.setDescripcion("Plataforma educativa que visualiza paso a paso diferentes algoritmos de ordenamiento (Bubble Sort, Quick Sort, Merge Sort, Insertion Sort, Selection Sort). Incluye comparaciones de complejidad, animaciones interactivas y análisis de rendimiento.");
            algoritmosOrdenamiento.setAutor("Sistema OVA");
            algoritmosOrdenamiento.setFechaCreacion(LocalDate.now());
            ovaRepository.save(algoritmosOrdenamiento);

            System.out.println("✓ OVAs iniciales cargadas: Simulador de Caché y Algoritmos de Ordenamiento Visuales");
        }
    }
}
