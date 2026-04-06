package com.jose.habittracker;

import com.jose.habittracker.model.Usuario;
import com.jose.habittracker.repository.UsuarioRepository;
import com.jose.habittracker.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository; // repositorio simulado

    @InjectMocks
    private UsuarioService usuarioService; // el service real

    @Test
    void getById_usuarioExiste_devuelveUsuario() {
        //ARRANGE
        Usuario usuario = new Usuario (1L, "Jose", "jose@email.com");
        when(repository.findById(1L)).thenReturn(Optional.of(usuario));

        //ACT
        Usuario resultado = usuarioService.getById(1L);

        //ASSERT
        assertEquals("Jose", resultado.getNombre());
        assertEquals("jose@email.com", resultado.getEmail());
    }

    @Test
    void getById_usuarioNoExiste_lanzaExcepcion() {
        // ARRANGE
        when(repository.findById(999L)).thenReturn(Optional.empty());

        // ACT Y ASSERT
        assertThrows(RuntimeException.class, () -> usuarioService.getById(999L));
    }
}
