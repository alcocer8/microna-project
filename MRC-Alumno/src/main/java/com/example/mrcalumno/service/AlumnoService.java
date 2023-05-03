package com.example.mrcalumno.service;

import com.example.mrcalumno.models.Alumno;
import com.example.mrcalumno.repository.AlumnoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@Slf4j
public class AlumnoService{

    @Autowired
    private AlumnoRepository repository;

    public Alumno getAlumnoById(String matricula) {
        return repository.findById(matricula).get();
    }

    public List<Alumno> getAllAlumnos() {
        return repository.findAll();
    }

    public void insertAlumno(Alumno alumno) {
        repository.save(alumno);
    }

    public void deleteAlumno(Alumno alumno) {
        repository.delete(alumno);
    }

    public void updateAlumno(Alumno alumno) {
        Alumno a = repository.findById(alumno.getMatricula()).get();
        a.setNombre(alumno.getNombre());
        a.setApellido(alumno.getApellido());
        a.setEdad(alumno.getEdad());
        a.setCreditos(alumno.getCreditos());
        a.setSemestre(alumno.getSemestre());

        repository.save(alumno);
    }
}
