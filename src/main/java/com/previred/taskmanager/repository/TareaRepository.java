package com.previred.taskmanager.repository;

import com.previred.taskmanager.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
