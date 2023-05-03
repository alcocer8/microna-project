package com.example.mrcalumno.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "matricula")
    private String matricula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String Apellido;

    @Column(name = "edad")
    private int edad;

    @Column(name = "creditos")
    private int creditos;

    @Column(name = "semestre")
    private int semestre;

    @Column(name = "carrera_id")
    private int carrera_id;


}
