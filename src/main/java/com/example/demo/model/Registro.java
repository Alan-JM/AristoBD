package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "registros")
public class Registro {

    @Id
    @Column(name = "telefono", length = 10)
    private String telefono;   // PRIMARY KEY

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "correo", nullable = false, length = 50)
    private String correo;
}