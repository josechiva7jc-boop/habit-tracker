package com.jose.habittracker.controller;


import com.jose.habittracker.model.Comentario;
import com.jose.habittracker.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    private ComentarioService service;

    @GetMapping
    public List<Comentario> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Comentario> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping
    public ResponseEntity<Comentario> create(@RequestBody Comentario comentario) {
        Comentario nuevo = service.create(comentario);
        return ResponseEntity.status(201).body(nuevo);
    }
    @PutMapping("/{id}")
    public Comentario updateById (@PathVariable Long id, @RequestBody Comentario comentario) {
        return service.update(id, comentario);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
