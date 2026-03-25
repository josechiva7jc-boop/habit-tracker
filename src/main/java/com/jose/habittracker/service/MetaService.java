package com.jose.habittracker.service;

import com.jose.habittracker.model.Meta;
import com.jose.habittracker.repository.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaService {
    @Autowired
    private MetaRepository repository;

    public List<Meta> getAll() {
        return repository.findAll();
    }
    public Meta create (Meta meta) {
        return repository.save(meta);
    }
    public void deleteMeta (Long id) {
        repository.deleteById(id);
    }
    public Meta updateMeta(Long id, Meta meta) {
        Meta existente = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Meta no encontrada"));
        existente.setTitulo(meta.getTitulo());
        existente.setDescripcion(meta.getDescripcion());
        return repository.save(existente);
    }
}
