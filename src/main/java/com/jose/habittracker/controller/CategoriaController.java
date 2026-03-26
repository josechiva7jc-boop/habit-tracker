package com.jose.habittracker.controller;

import com.jose.habittracker.model.Categoria;
import com.jose.habittracker.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAll() {
        return categoriaService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById (@PathVariable Long id) {
        return categoriaService.getById(id)
                .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Categoria> nuevaCategoria (@Valid @RequestBody Categoria categoria) {
        Categoria nueva = categoriaService.create(categoria);
        return ResponseEntity.status(201).body(nueva);
    }
    @PutMapping("/{id}")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria) {
return categoriaService.update(id, categoria);
    }
    @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete (@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
        }
}
