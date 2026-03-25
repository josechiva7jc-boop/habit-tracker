package com.jose.habittracker.model;

import jakarta.persistence.*;

@Entity
@Table(name="habitos")
public class Habito {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String frecuencia;
    @ManyToOne
    @JoinColumn(name = "meta_id")
    private Meta meta;

    public Habito(String nombre, String frecuencia, Meta meta) {
        this.nombre = nombre;
        this.frecuencia = frecuencia;
        this.meta = meta;
    }
    public Habito() {
    }

    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

    public Meta getMeta() {
        return meta;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}


