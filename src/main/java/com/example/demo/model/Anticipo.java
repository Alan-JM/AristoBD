package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "anticipos")
public class Anticipo {

    @Id
    @Column(name = "idFolio", length = 10)
    private String idFolio;

    @Column(name = "fecha", nullable = false)
    private java.sql.Date fecha;

    @Column(name = "UnidadTrans", nullable = false, length = 10)
    private String unidadTrans;

    @Column(name = "Operador", nullable = false, length = 50)
    private String operador;

    @Column(name = "importe", nullable = false, precision = 5, scale = 2)
    private BigDecimal importe;

    @Column(name = "concepto", length = 100)
    private String concepto;

    @Column(name = "observaciones", length = 200)
    private String observaciones;
}