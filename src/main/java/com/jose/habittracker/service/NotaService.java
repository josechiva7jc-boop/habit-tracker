package com.jose.habittracker.service;

import com.jose.habittracker.model.Nota;
import com.jose.habittracker.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    private NotaRepository repository;

    public List<Nota> getAll() {
        return repository.findAll();
    }
    public Nota getById (Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota no encontrada con id: " + id));
    }
    public Nota create(Nota nota) {
        return repository.save(nota);
    }
    public Nota update (Long id, Nota nota) {
        Nota existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota no encontrada"));
        existente.setContenido(nota.getContenido());
        existente.setFecha(nota.getFecha());
        return repository.save(existente);
    }
    public void delete (Long id) {
        repository.deleteById(id);
    }
}
