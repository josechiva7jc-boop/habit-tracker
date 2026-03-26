package com.jose.habittracker.service;

import com.jose.habittracker.model.Categoria;
import com.jose.habittracker.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> getAll () {
        return repository.findAll();
    }
    public Optional<Categoria> getById(Long id) {
        return repository.findById(id);
    }
    public Categoria create (Categoria categoria) {
        return repository.save(categoria);
    }
    public Categoria update (Long id, Categoria categoria) {
        Categoria existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        existente.setNombre(categoria.getNombre());
        existente.setDescripcion(categoria.getDescripcion());
        return repository.save(existente);
    }
    public void delete (Long id) {
        repository.deleteById(id);
    }
}
