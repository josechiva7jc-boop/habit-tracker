package com.jose.habittracker.controller;

import com.jose.habittracker.model.Usuario;
import com.jose.habittracker.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario nuevo = usuarioService.createUsuario(usuario);
        return ResponseEntity.status(201).body(nuevo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public Usuario update (@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(id, usuario);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> encontrarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.getById(id));
    }
    @GetMapping("/buscar")
    public List<Usuario> findByNombre (@RequestParam String nombre) {
        return usuarioService.getByNombre(nombre);
    }
}
