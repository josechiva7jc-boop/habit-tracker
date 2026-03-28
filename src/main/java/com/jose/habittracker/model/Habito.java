package com.jose.habittracker.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "habitos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Habito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String frecuencia;

    @ManyToOne
    @JoinColumn(name = "meta_id")
    private Meta meta;
}