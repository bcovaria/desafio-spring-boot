package com.previred.taskmanager.repository;

import com.previred.taskmanager.entity.EstadoTarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoTareaRepository extends JpaRepository<EstadoTarea, Long> {
    EstadoTarea findByNombre(String nombre);
}
