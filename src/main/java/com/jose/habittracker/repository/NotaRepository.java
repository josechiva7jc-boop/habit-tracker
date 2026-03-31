package com.jose.habittracker.repository;

import com.jose.habittracker.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository <Nota, Long> {
}
