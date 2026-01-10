package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistroDto {
    private String telefono;
    private String nombre;
    private String correo;
}