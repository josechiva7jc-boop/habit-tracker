package com.jose.habittracker.service;

import com.jose.habittracker.model.Comentario;
import com.jose.habittracker.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository repository;

    public List<Comentario> getAll(){
        return repository.findAll();
    }
    public Comentario getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado con id: " + id));
    }
    public Comentario create(Comentario comentario) {
        return repository.save(comentario);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
    public Comentario update(Long id, Comentario comentario) {
        Comentario existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
        existente.setTexto(comentario.getTexto());
        existente.setAutor(comentario.getAutor());
        return repository.save(existente);
    }
}

