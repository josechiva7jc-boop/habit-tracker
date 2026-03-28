package com.jose.habittracker.repository;

import com.jose.habittracker.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNombreContainingIgnoreCase (String nombre);
}
