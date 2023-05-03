package com.example.mrcprofesor.controller;

import com.example.mrcprofesor.model.Profesor;
import com.example.mrcprofesor.service.ProfesorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class ProfesorController {

    @Autowired
    private ProfesorService service;

    @RequestMapping(value = "api/profesor/{profesor_id}", method = RequestMethod.GET)
    public ResponseEntity<Profesor> getProfesorById(@PathVariable Long profesor_id) {
        try {
            Profesor p = service.getProfesorById(profesor_id);
            return new ResponseEntity<>(p, HttpStatus.OK);
        } catch (Exception e) {
            log.info(e.toString());
            return new ResponseEntity<>(new Profesor(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "api/profesor", method = RequestMethod.GET)
    public List<Profesor> getAllProfesor() {
        return service.getAllProfesor();
    }

    @RequestMapping(value = "api/profesor", method = RequestMethod.POST)
    public ResponseEntity<List<Profesor>> insertProfesor(@RequestBody Profesor profesor) {
        try {
            service.insertProfesor(profesor);
            return new ResponseEntity<>(service.getAllProfesor(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

   @RequestMapping(value = "api/profesor", method = RequestMethod.DELETE)
   public ResponseEntity<List<Profesor>> deleteProfesor(@RequestBody Profesor profesor){
        try{
            service.deleteProfesor(profesor);
            return new ResponseEntity<>(service.getAllProfesor(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
   }

    @RequestMapping(value = "api/profesor", method = RequestMethod.PUT)
    public ResponseEntity<Profesor> updateProfesor(@RequestBody Profesor profesor){
        try{
            service.updateProfesor(profesor);
            return new ResponseEntity<>(service.getProfesorById(profesor.getProfesor_id()), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Profesor(), HttpStatus.BAD_REQUEST);
        }
    }
}
