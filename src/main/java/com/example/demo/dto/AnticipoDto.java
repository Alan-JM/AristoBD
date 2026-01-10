package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@Builder
public class AnticipoDto {
    private String idFolio;
    private Date fecha;
    private String unidadTrans;
    private String operador;
    private BigDecimal importe;
    private String concepto;
    private String observaciones;
}