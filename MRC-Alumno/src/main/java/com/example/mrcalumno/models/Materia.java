package com.example.mrcalumno.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Table(name = "materia")
@Entity
@Data
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "materia_id")
    private Long materia_id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "creditos")
    private int creditos;

}
