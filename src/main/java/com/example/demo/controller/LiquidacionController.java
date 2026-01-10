package com.example.demo.controller;

import com.example.demo.dto.LiquidacionDto;
import com.example.demo.model.Liquidacion;
import com.example.demo.service.LiquidacionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class LiquidacionController {

    private final LiquidacionService liquidacionService;

    @GetMapping("/liquidacion")
    public ResponseEntity<List<LiquidacionDto>> getAll() {
        List<Liquidacion> liquidaciones = liquidacionService.getAll();
        if (liquidaciones.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<LiquidacionDto> result = liquidaciones.stream()
                .map(l -> LiquidacionDto.builder()
                        .idFolio(l.getIdFolio())
                        .fecha(l.getFecha())
                        .operador(l.getOperador())
                        .bonoExt(l.getBonoExt())
                        .resumen(l.getResumen())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/liquidacion/{idFolio}")
    public ResponseEntity<LiquidacionDto> getByIdFolio(@PathVariable String idFolio) {
        Liquidacion l = liquidacionService.getByIdFolio(idFolio);
        if (l == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(LiquidacionDto.builder()
                .idFolio(l.getIdFolio())
                .fecha(l.getFecha())
                .operador(l.getOperador())
                .bonoExt(l.getBonoExt())
                .resumen(l.getResumen())
                .build());
    }

    @PostMapping("/liquidacion")
    public ResponseEntity<LiquidacionDto> save(@RequestBody LiquidacionDto liquidacionDto) {
        Liquidacion l = Liquidacion.builder()
                .idFolio(liquidacionDto.getIdFolio())
                .fecha(liquidacionDto.getFecha())
                .operador(liquidacionDto.getOperador())
                .bonoExt(liquidacionDto.getBonoExt())
                .resumen(liquidacionDto.getResumen())
                .build();
        Liquidacion saved = liquidacionService.save(l);
        return ResponseEntity.ok(LiquidacionDto.builder()
                .idFolio(saved.getIdFolio())
                .fecha(saved.getFecha())
                .operador(saved.getOperador())
                .bonoExt(saved.getBonoExt())
                .resumen(saved.getResumen())
                .build());
    }

    @DeleteMapping("/liquidacion/{idFolio}")
    public ResponseEntity<Void> delete(@PathVariable String idFolio) {
        liquidacionService.delete(idFolio);
        return ResponseEntity.ok().build();
    }
}