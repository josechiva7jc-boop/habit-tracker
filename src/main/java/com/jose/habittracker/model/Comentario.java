package com.jose.habittracker.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comentarios")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;
    private String autor;
    @ManyToOne
    @JoinColumn(name = "habito_id")
    private Habito habito;
}
