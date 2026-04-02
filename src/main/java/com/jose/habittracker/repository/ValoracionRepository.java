package com.jose.habittracker.repository;

import com.jose.habittracker.model.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValoracionRepository extends JpaRepository<Valoracion, Long> {
}
