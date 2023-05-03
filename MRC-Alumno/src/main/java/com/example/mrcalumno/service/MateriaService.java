package com.example.mrcalumno.service;

import com.example.mrcalumno.models.Materia;
import com.example.mrcalumno.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository repository;

    public Materia getMateriaById(Long materia_id) {
        return repository.findById(materia_id).get();
    }

    public List<Materia> getAllMateria() {
        return repository.findAll();
    }

    public void insertMateria(Materia materia) {
        repository.save(materia);
    }

    public void updateMateria(Materia materia) {
        Materia m = repository.findById(materia.getMateria_id()).get();

        m.setNombre(materia.getNombre());
        m.setCreditos(materia.getCreditos());

        repository.save(m);
    }

    public void deleteMateria(Materia materia){
        repository.delete(materia);
    }
}
