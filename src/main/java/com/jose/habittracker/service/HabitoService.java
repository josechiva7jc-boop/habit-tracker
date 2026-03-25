package com.jose.habittracker.service;

import com.jose.habittracker.model.Habito;
import com.jose.habittracker.repository.HabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitoService {
    @Autowired
    private HabitoRepository repository;

    public List<Habito> getAll() {
        return repository.findAll();
    }
    public Habito create(Habito habito) {
        return repository.save(habito);
    }
}
