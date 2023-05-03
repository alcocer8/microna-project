package com.example.mrcprofesor.service;

import com.example.mrcprofesor.model.Profesor;
import com.example.mrcprofesor.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository repository;

    public Profesor getProfesorById(Long profesor_id) {
        return repository.findById(profesor_id).get();
    }

    public List<Profesor> getAllProfesor() {
        return repository.findAll();
    }

    public void insertProfesor(Profesor profesor) {
        repository.save(profesor);
    }

    public void updateProfesor(Profesor profesor) {
        Profesor p = repository.findById(profesor.getProfesor_id()).get();

        p.setNombre(profesor.getNombre());
        p.setApellido(profesor.getApellido());
        p.setCorreo(profesor.getCorreo());
        p.setPassword(profesor.getPassword());
        p.setTipo_usuario_id(profesor.getTipo_usuario_id());

        repository.save(p);
    }

    public void deleteProfesor(Profesor profesor){
        repository.delete(profesor);
    }
}
