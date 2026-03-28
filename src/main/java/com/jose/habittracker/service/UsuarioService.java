package com.jose.habittracker.service;

import com.jose.habittracker.model.Usuario;
import com.jose.habittracker.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> getAllUsuarios() {
        return repository.findAll();
    }

    public Usuario createUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        repository.deleteById(id);
    }

    public Usuario updateUsuario(Long id, Usuario usuario) {
        Usuario existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        existente.setNombre(usuario.getNombre());
        existente.setEmail(usuario.getEmail());
        return repository.save(existente);
    }
    public Usuario getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }

    public List<Usuario> getByNombre (String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }
}
