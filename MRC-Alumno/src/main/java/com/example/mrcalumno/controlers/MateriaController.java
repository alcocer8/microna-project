package com.example.mrcalumno.controlers;

import com.example.mrcalumno.models.Materia;
import com.example.mrcalumno.service.MateriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class MateriaController {

    private final MateriaService service;

    public MateriaController(MateriaService service) {
        this.service = service;
    }

    @RequestMapping(value = "api/materia/{materia_id}", method = RequestMethod.GET)
    public ResponseEntity<Materia> getMateriaById(@PathVariable Long materia_id){
        try{
            Materia m = service.getMateriaById(materia_id);
            return new ResponseEntity<>(m, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Materia(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "api/materia", method = RequestMethod.GET)
    public List<Materia> getAllMateria(){
        return service.getAllMateria();
    }

    @RequestMapping(value = "api/materia", method = RequestMethod.POST)
    public ResponseEntity<List<Materia>> insertMateria(@RequestBody Materia materia){
        try{
            service.insertMateria(materia);
            log.info(materia.toString());
            return new ResponseEntity<>(service.getAllMateria(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "api/materia", method = RequestMethod.DELETE)
    public ResponseEntity<List<Materia>> deleteMateria(@RequestBody Materia materia){
        try{
            service.deleteMateria(materia);
            return new ResponseEntity<>(service.getAllMateria(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "api/materia", method = RequestMethod.PUT)
    public ResponseEntity<Materia> updateMateria(@RequestBody Materia materia){
        try{
            service.updateMateria(materia);

            return new ResponseEntity<>(materia, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Materia(), HttpStatus.BAD_REQUEST);
        }

    }
}
