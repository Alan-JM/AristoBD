package com.example.demo.controller;

import com.example.demo.dto.PerfilDto;
import com.example.demo.model.Perfil;
import com.example.demo.service.PerfilService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class PerfilController {

    private final PerfilService perfilService;

    @GetMapping("/perfil")
    public ResponseEntity<List<PerfilDto>> getAll() {
        List<Perfil> perfiles = perfilService.getAll();
        if (perfiles.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<PerfilDto> result = perfiles.stream()
                .map(p -> PerfilDto.builder()
                        .nombre(p.getNombre())
                        .fechaNac(p.getFechaNac())
                        .curp(p.getCurp())
                        .nss(p.getNss())
                        .correo(p.getCorreo())
                        .telefono(p.getTelefono())
                        .usuario(p.getUsuario())
                        .contrasena(p.getContrasena())
                        .inicio(p.getInicio())
                        .rol(p.getRol())
                        .clave(p.getClave())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/perfil/{telefono}")
    public ResponseEntity<PerfilDto> getByTelefono(@PathVariable String telefono) {
        Perfil p = perfilService.getByTelefono(telefono);
        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(PerfilDto.builder()
                .nombre(p.getNombre())
                .fechaNac(p.getFechaNac())
                .curp(p.getCurp())
                .nss(p.getNss())
                .correo(p.getCorreo())
                .telefono(p.getTelefono())
                .usuario(p.getUsuario())
                .contrasena(p.getContrasena())
                .inicio(p.getInicio())
                .rol(p.getRol())
                .clave(p.getClave())
                .build());
    }

    @PostMapping("/perfil")
    public ResponseEntity<PerfilDto> save(@RequestBody PerfilDto perfilDto) {
        Perfil p = Perfil.builder()
                .nombre(perfilDto.getNombre())
                .fechaNac(perfilDto.getFechaNac())
                .curp(perfilDto.getCurp())
                .nss(perfilDto.getNss())
                .correo(perfilDto.getCorreo())
                .telefono(perfilDto.getTelefono())
                .usuario(perfilDto.getUsuario())
                .contrasena(perfilDto.getContrasena())
                .inicio(perfilDto.getInicio())
                .rol(perfilDto.getRol())
                .clave(perfilDto.getClave())
                .build();
        Perfil saved = perfilService.save(p);
        return ResponseEntity.ok(PerfilDto.builder()
                .nombre(saved.getNombre())
                .fechaNac(saved.getFechaNac())
                .curp(saved.getCurp())
                .nss(saved.getNss())
                .correo(saved.getCorreo())
                .telefono(saved.getTelefono())
                .usuario(saved.getUsuario())
                .contrasena(saved.getContrasena())
                .inicio(saved.getInicio())
                .rol(saved.getRol())
                .clave(saved.getClave())
                .build());
    }

    @DeleteMapping("/perfil/{telefono}")
    public ResponseEntity<Void> delete(@PathVariable String telefono) {
        perfilService.delete(telefono);
        return ResponseEntity.ok().build();
    }
}