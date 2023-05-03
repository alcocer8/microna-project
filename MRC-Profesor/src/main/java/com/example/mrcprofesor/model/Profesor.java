package com.example.mrcprofesor.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ValueGenerationType;

import java.io.Serializable;

@Data
@Entity
@Table(name = "profesor")
public class Profesor implements Serializable {

    //private static long
    @Id
    @Column(name = "profesor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profesor_id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "correo")
    private String correo;

    @Column(name = "password")
    private String password;

    @Column(name = "tipo_usuario_id")
    private int tipo_usuario_id;
}
