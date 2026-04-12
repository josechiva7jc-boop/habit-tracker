package com.jose.habittracker;

import com.jose.habittracker.security.JwtFilter;
import com.jose.habittracker.security.JwtUtil;
import com.jose.habittracker.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = com.jose.habittracker.controller.UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private JwtFilter jwtFilter;

    @Test
    @WithMockUser
    void getAll_devuelve200() throws Exception {
        when(usuarioService.getAllUsuarios()).thenReturn(List.of());

        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isOk());
    }
}