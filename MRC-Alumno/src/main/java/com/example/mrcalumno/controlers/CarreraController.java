package com.example.mrcalumno.controlers;

import com.example.mrcalumno.models.Carrera;
import com.example.mrcalumno.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarreraController {

    @Autowired
    private CarreraService service;

    @RequestMapping(value = "api/carrera/{carrera_id}", method = RequestMethod.GET)
    public ResponseEntity<Carrera> getCarreraById(@PathVariable Long carrera_id) {
        try {
            Carrera c = service.getCarreraById(carrera_id);
            return new ResponseEntity<Carrera>(c, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Carrera>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "api/carrera", method = RequestMethod.GET)
    public List<Carrera> getAllCarrera() {
        return service.getAllCarrera();
    }

    @RequestMapping(value = "api/carrera", method = RequestMethod.POST)
    public void insertCarrera(@RequestBody Carrera carrera) {
        service.insertCarrera(carrera);
    }

    @RequestMapping(value = "api/carrera", method = RequestMethod.DELETE)
    public void deleteCarrera(@RequestBody Carrera carrera) {
        service.deleteCarrera(carrera);
    }

    @RequestMapping(value = "api/carrera", method = RequestMethod.PUT)
    public ResponseEntity updateCarrera(@RequestBody Carrera carrera) {
        try {
            service.updateCarrera(carrera);
            return new ResponseEntity<Carrera>(carrera, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Carrera>(HttpStatus.NOT_FOUND);
        }
    }
}
