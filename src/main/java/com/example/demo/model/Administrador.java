package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "administradores")
public class Administrador {

    @Id
    @Column(name = "clave", length = 10)
    private String clave;   // PRIMARY KEY

    @Column(name = "uso", columnDefinition = "INT DEFAULT 0")
    private Integer uso;

    @Column(name = "telefono", length = 20)
    private String telefono;
}