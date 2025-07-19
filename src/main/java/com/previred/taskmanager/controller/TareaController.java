package com.previred.taskmanager.controller;

import com.previred.taskmanager.model.TareaModel;
import com.previred.taskmanager.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    @GetMapping
    public List<TareaModel> getAll() {
        return tareaService.getAllTareas();
    }

    @GetMapping("/{id}")
    public TareaModel getById(@PathVariable Long id) {
        return tareaService.getTareaById(id);
    }

    @PostMapping
    public TareaModel create(@RequestBody TareaModel model) {
        return tareaService.createTarea(model);
    }

    @PutMapping("/{id}")
    public TareaModel update(@PathVariable Long id, @RequestBody TareaModel model) {
        return tareaService.updateTarea(id, model);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tareaService.deleteTarea(id);
    }
}
