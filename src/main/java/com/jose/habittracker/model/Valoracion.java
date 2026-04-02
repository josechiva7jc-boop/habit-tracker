package com.jose.habittracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name="valoraciones")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Valoracion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    private int puntuacion;

    private String comentario;

    @ManyToOne
    @JoinColumn(name="habito_id")
    private Habito habito;
}
