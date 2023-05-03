package com.example.mrcprofesor.repository;

import com.example.mrcprofesor.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
