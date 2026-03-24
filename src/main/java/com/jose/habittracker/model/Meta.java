package com.jose.habittracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "meta")


public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Meta(String titulo, Usuario usuario) {
        this.titulo = titulo;
        this.usuario = usuario;
    }
    public Meta() {
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

