package com.example.demo.controller;

import com.example.demo.dto.AnticipoDto;
import com.example.demo.model.Anticipo;
import com.example.demo.service.AnticipoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class AnticipoController {

    private final AnticipoService anticipoService;

    @GetMapping("/anticipo")
    public ResponseEntity<List<AnticipoDto>> getAll() {
        List<Anticipo> anticipos = anticipoService.getAll();
        if (anticipos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<AnticipoDto> result = anticipos.stream()
                .map(a -> AnticipoDto.builder()
                        .idFolio(a.getIdFolio())
                        .fecha(a.getFecha())
                        .unidadTrans(a.getUnidadTrans())
                        .operador(a.getOperador())
                        .importe(a.getImporte())
                        .concepto(a.getConcepto())
                        .observaciones(a.getObservaciones())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/anticipo/{idFolio}")
    public ResponseEntity<AnticipoDto> getByIdFolio(@PathVariable String idFolio) {
        Anticipo a = anticipoService.getByIdFolio(idFolio);
        if (a == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(AnticipoDto.builder()
                .idFolio(a.getIdFolio())
                .fecha(a.getFecha())
                .unidadTrans(a.getUnidadTrans())
                .operador(a.getOperador())
                .importe(a.getImporte())
                .concepto(a.getConcepto())
                .observaciones(a.getObservaciones())
                .build());
    }

    @PostMapping("/anticipo")
    public ResponseEntity<AnticipoDto> save(@RequestBody AnticipoDto anticipoDto) {
        Anticipo a = Anticipo.builder()
                .idFolio(anticipoDto.getIdFolio())
                .fecha(anticipoDto.getFecha())
                .unidadTrans(anticipoDto.getUnidadTrans())
                .operador(anticipoDto.getOperador())
                .importe(anticipoDto.getImporte())
                .concepto(anticipoDto.getConcepto())
                .observaciones(anticipoDto.getObservaciones())
                .build();
        Anticipo saved = anticipoService.save(a);
        return ResponseEntity.ok(AnticipoDto.builder()
                .idFolio(saved.getIdFolio())
                .fecha(saved.getFecha())
                .unidadTrans(saved.getUnidadTrans())
                .operador(saved.getOperador())
                .importe(saved.getImporte())
                .concepto(saved.getConcepto())
                .observaciones(saved.getObservaciones())
                .build());
    }

    @DeleteMapping("/anticipo/{idFolio}")
    public ResponseEntity<Void> delete(@PathVariable String idFolio) {
        anticipoService.delete(idFolio);
        return ResponseEntity.ok().build();
    }
}