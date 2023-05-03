package com.example.mrcalumno.service;

import com.example.mrcalumno.models.Carrera;
import com.example.mrcalumno.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository repository;

    public Carrera getCarreraById(Long carrera_id) {
        return repository.findById(carrera_id).get();
    }

    public List<Carrera> getAllCarrera() {
        return repository.findAll();
    }

    public void insertCarrera(Carrera carrera) {
        repository.save(carrera);
    }

    public void deleteCarrera(Carrera carrera) {
        repository.delete(carrera);
    }

    public void updateCarrera(Carrera carrera) {
        Carrera c = repository.findById(carrera.getCarrera_id()).get();

        c.setNombre(carrera.getNombre());
        c.setDuracion(carrera.getDuracion());
        c.setCreditos(carrera.getCreditos());

        repository.save(c);
    }
}
