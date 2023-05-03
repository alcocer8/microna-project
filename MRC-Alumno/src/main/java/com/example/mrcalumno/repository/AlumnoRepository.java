package com.example.mrcalumno.repository;

import com.example.mrcalumno.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, String> {
}
