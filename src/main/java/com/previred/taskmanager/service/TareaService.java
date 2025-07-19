package com.previred.taskmanager.service;


import com.previred.taskmanager.entity.EstadoTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.previred.taskmanager.repository.TareaRepository;
import com.previred.taskmanager.repository.EstadoTareaRepository;
import com.previred.taskmanager.model.TareaModel;
import com.previred.taskmanager.entity.Tarea;


import java.util.List;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;
    @Autowired
    private EstadoTareaRepository estadoTareaRepository;

    public List<TareaModel> getAllTareas() {
        return tareaRepository.findAll().stream().map(this::convertToModel).toList();
    }

    public TareaModel getTareaById(Long id) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada con id: " + id));
        return convertToModel(tarea);
    }

    public TareaModel createTarea(TareaModel model) {
        Tarea tarea = new Tarea();
        tarea.setTitulo(model.getTitulo());
        tarea.setDescripcion(model.getDescripcion());
        tarea.setEstado(estadoTareaRepository.findById(1L).orElseThrow()); // asigna estado por defecto
        tarea = tareaRepository.save(tarea);
        return convertToModel(tarea);
    }

    public TareaModel updateTarea(Long id, TareaModel model) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada con id: " + id));

        tarea.setTitulo(model.getTitulo());
        tarea.setDescripcion(model.getDescripcion());


        if (model.getEstadoNombre() != null) {
            EstadoTarea estado = estadoTareaRepository.findByNombre(model.getEstadoNombre());
            if (estado == null) {
                throw new RuntimeException("Estado no encontrado con nombre: " + model.getEstadoNombre());
            }
            tarea.setEstado(estado);
        }


        tarea = tareaRepository.save(tarea);
        return convertToModel(tarea);
    }

    public void deleteTarea(Long id) {
        tareaRepository.deleteById(id);
    }

    private TareaModel convertToModel(Tarea tarea) {
        TareaModel model = new TareaModel();
        model.setId(tarea.getId());
        model.setTitulo(tarea.getTitulo());
        model.setDescripcion(tarea.getDescripcion());
        model.setEstadoNombre(tarea.getEstado().getNombre());
        return model;
    }
}

