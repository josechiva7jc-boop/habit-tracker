package com.jose.habittracker.controller;

import com.jose.habittracker.model.Valoracion;
import com.jose.habittracker.service.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/valoracion")
public class ValoracionController {
    @Autowired
    private ValoracionService service;

    @GetMapping
    public List<Valoracion> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Valoracion> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping
    public ResponseEntity<Valoracion> create (@RequestBody Valoracion valoracion){
        Valoracion nueva = service.create(valoracion);
        return ResponseEntity.status(201).body(nueva);
    }
    @PutMapping("/{id}")
    public Valoracion update (@PathVariable Long id, @RequestBody Valoracion valoracion) {
        return service.update(id, valoracion);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        service.delete(id);
                return ResponseEntity.status(204).build();
    }

}
