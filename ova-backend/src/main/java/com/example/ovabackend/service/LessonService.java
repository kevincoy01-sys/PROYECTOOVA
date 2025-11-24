package com.example.ovabackend.service;

import com.example.ovabackend.model.Lesson;
import com.example.ovabackend.model.Module;
import com.example.ovabackend.repository.LessonRepository;
import com.example.ovabackend.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Optional<Lesson> getLessonById(Long id) {
        return lessonRepository.findById(id);
    }

    public List<Lesson> getLessonsByModuleId(Long moduleId) {
        return lessonRepository.findByModuleIdOrderByOrdenAsc(moduleId);
    }

    public Lesson createLesson(Long moduleId, Lesson lesson) {
        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new RuntimeException("Módulo no encontrado con id: " + moduleId));
        
        lesson.setModule(module);
        return lessonRepository.save(lesson);
    }

    public Lesson updateLesson(Long id, Lesson lessonDetails) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lección no encontrada con id: " + id));

        lesson.setTitulo(lessonDetails.getTitulo());
        lesson.setContenido(lessonDetails.getContenido());
        lesson.setOrden(lessonDetails.getOrden());

        return lessonRepository.save(lesson);
    }

    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }
}
