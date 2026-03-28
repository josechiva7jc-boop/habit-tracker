package com.jose.habittracker.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "meta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}