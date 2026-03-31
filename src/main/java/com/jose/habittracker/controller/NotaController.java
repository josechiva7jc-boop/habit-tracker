package com.jose.habittracker.controller;

import com.jose.habittracker.model.Nota;
import com.jose.habittracker.service.NotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {
    @Autowired
    public NotaService service;

    @GetMapping
    public List<Nota> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Nota> getById (@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping
    public ResponseEntity<Nota> create(@Valid @RequestBody Nota nota) {
        Nota nueva = service.create(nota);
        return ResponseEntity.status(201).body(nueva);
    }
    @PutMapping("/{id}")
    public Nota update (@PathVariable Long id, @RequestBody Nota nota) {
        return service.update(id, nota);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
         service.delete(id);
         return ResponseEntity.noContent().build();
    }
}
