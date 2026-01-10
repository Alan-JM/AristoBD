package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "perfil")
public class Perfil {

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "fechaNac", nullable = false)
    private java.sql.Date fechaNac;

    @Column(name = "curp", nullable = false, length = 18)
    private String curp;

    @Column(name = "nss", nullable = false, length = 11)
    private String nss;

    @Column(name = "correo", nullable = false, length = 50)
    private String correo;

    @Id
    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;   // PRIMARY KEY

    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;

    @Column(name = "contrasena", nullable = false, length = 50)
    private String contrasena;

    @Column(name = "inicio", columnDefinition = "INT DEFAULT 0")
    private Integer inicio;

    @Column(name = "rol", columnDefinition = "INT DEFAULT 0")
    private Integer rol;

    @Column(name = "clave", unique = true, length = 10)
    private String clave;
}