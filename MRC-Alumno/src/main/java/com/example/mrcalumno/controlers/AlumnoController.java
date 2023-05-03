package com.example.mrcalumno.controlers;

import com.example.mrcalumno.service.AlumnoService;
import com.example.mrcalumno.models.Alumno;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class AlumnoController {

    @Autowired
    AlumnoService alumnoDao;

    @RequestMapping(value = "api/alumnos", method = RequestMethod.GET)
    public List<Alumno> getAllAlumnos() {
        return alumnoDao.getAllAlumnos();
    }

    @RequestMapping(value = "api/alumnos/{matricula}", method=RequestMethod.GET)
    public Alumno getAlumnoById(@PathVariable String matricula){
        return alumnoDao.getAlumnoById(matricula);
    }

    @RequestMapping(value = "api/alumnos", method = RequestMethod.POST)
    public void insertAlumno(@RequestBody Alumno alumno){
        alumnoDao.insertAlumno(alumno);
    }

    @RequestMapping(value = "api/alumnos", method = RequestMethod.DELETE)
    public void deleteAlumno(@RequestBody Alumno alumno){
        alumnoDao.deleteAlumno(alumno);
    }

    @RequestMapping(value = "api/alumnos", method = RequestMethod.PUT)
    public void updateAlumno(@RequestBody Alumno alumno){
        alumnoDao.updateAlumno(alumno);
    }
}
