package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroDto {
    private String telefono;
    private String nombre;
    private String correo;
    private int enviado;
}