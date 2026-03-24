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
}
