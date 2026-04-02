package com.jose.habittracker.service;

import com.jose.habittracker.model.Valoracion;
import com.jose.habittracker.repository.ValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValoracionService {
    @Autowired
    private ValoracionRepository repository;

    public List<Valoracion> getAll() {
        return repository.findAll();
    }
    public Valoracion getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Valoración no encontrada con ID " + id));
    }
    public Valoracion update (Long id, Valoracion valoracion) {
        Valoracion existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe valoración con ese ID"));
                existente.setComentario(valoracion.getComentario());
                existente.setPuntuacion(valoracion.getPuntuacion());
                return repository.save(existente);
    }
    public Valoracion create (Valoracion valoracion) {
        return repository.save(valoracion);
    }
    public void delete (Long id) {
        repository.deleteById(id);
    }
}
