package com.example.demo.controller;

import com.example.demo.dto.BitacoraDto;
import com.example.demo.model.Bitacora;
import com.example.demo.model.Liquidacion;
import com.example.demo.service.BitacoraService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class BitacoraController {

    private final BitacoraService bitacoraService;

    @GetMapping("/bitacora")
    public ResponseEntity<List<BitacoraDto>> getAll() {
        List<Bitacora> bitacoras = bitacoraService.getAll();
        if (bitacoras.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<BitacoraDto> result = bitacoras.stream()
                .map(b -> BitacoraDto.builder()
                        .idFolio(b.getIdFolio())
                        .fecha(b.getFecha())
                        .operador(b.getOperador())
                        .unidadEco(b.getUnidadEco())
                        .cliente(b.getCliente())
                        .destino(b.getDestino())
                        .ayudantes(b.getAyudantes())
                        .odometroInicial(b.getOdometroInicial())
                        .odometroFinal(b.getOdometroFinal())
                        .distanciaTotal(b.getDistanciaTotal())
                        .combustibleConsumido(b.getCombustibleConsumido())
                        .gastoTCombustible(b.getGastoTCombustible())
                        .gastoTCasetas(b.getGastoTCasetas())
                        .subTotalT(b.getSubTotalT())
                        .gastoECombustible(b.getGastoECombustible())
                        .gastoECasetas(b.getGastoECasetas())
                        .gastoEComida(b.getGastoEComida())
                        .gastoEReparaciones(b.getGastoEReparaciones())
                        .gastoEManiobras(b.getGastoEManiobras())
                        .gastoETransito(b.getGastoETransito())
                        .gastoEOtros(b.getGastoEOtros())
                        .subTotalE(b.getSubTotalE())
                        .granTotal(b.getGranTotal())
                        .telefonoAdmin(b.getTelefonoAdmin())
                        .telefono(b.getTelefono())
                        .confirmacion(b.getConfirmacion())
                        .liquidacion(b.getLiquidacion() != null ? b.getLiquidacion().getIdFolio() : null)
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/bitacora/{idFolio}")
    public ResponseEntity<BitacoraDto> getByIdFolio(@PathVariable Integer idFolio) {
        Bitacora b = bitacoraService.getByIdFolio(idFolio);
        if (b == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(BitacoraDto.builder()
                .idFolio(b.getIdFolio())
                .fecha(b.getFecha())
                .operador(b.getOperador())
                .unidadEco(b.getUnidadEco())
                .cliente(b.getCliente())
                .destino(b.getDestino())
                .ayudantes(b.getAyudantes())
                .odometroInicial(b.getOdometroInicial())
                .odometroFinal(b.getOdometroFinal())
                .distanciaTotal(b.getDistanciaTotal())
                .combustibleConsumido(b.getCombustibleConsumido())
                .gastoTCombustible(b.getGastoTCombustible())
                .gastoTCasetas(b.getGastoTCasetas())
                .subTotalT(b.getSubTotalT())
                .gastoECombustible(b.getGastoECombustible())
                .gastoECasetas(b.getGastoECasetas())
                .gastoEComida(b.getGastoEComida())
                .gastoEReparaciones(b.getGastoEReparaciones())
                .gastoEManiobras(b.getGastoEManiobras())
                .gastoETransito(b.getGastoETransito())
                .gastoEOtros(b.getGastoEOtros())
                .subTotalE(b.getSubTotalE())
                .granTotal(b.getGranTotal())
                .telefonoAdmin(b.getTelefonoAdmin())
                .telefono(b.getTelefono())
                .confirmacion(b.getConfirmacion())
                .liquidacion(b.getLiquidacion() != null ? b.getLiquidacion().getIdFolio() : null)
                .build());
    }

    @PostMapping("/bitacora")
    public ResponseEntity<BitacoraDto> save(@RequestBody BitacoraDto bitacoraDto) {
        Bitacora b = Bitacora.builder()
                .fecha(bitacoraDto.getFecha())
                .operador(bitacoraDto.getOperador())
                .unidadEco(bitacoraDto.getUnidadEco())
                .cliente(bitacoraDto.getCliente())
                .destino(bitacoraDto.getDestino())
                .ayudantes(bitacoraDto.getAyudantes())
                .odometroInicial(bitacoraDto.getOdometroInicial())
                .odometroFinal(bitacoraDto.getOdometroFinal())
                .distanciaTotal(bitacoraDto.getDistanciaTotal())
                .combustibleConsumido(bitacoraDto.getCombustibleConsumido())
                .gastoTCombustible(bitacoraDto.getGastoTCombustible())
                .gastoTCasetas(bitacoraDto.getGastoTCasetas())
                .subTotalT(bitacoraDto.getSubTotalT())
                .gastoECombustible(bitacoraDto.getGastoECombustible())
                .gastoECasetas(bitacoraDto.getGastoECasetas())
                .gastoEComida(bitacoraDto.getGastoEComida())
                .gastoEReparaciones(bitacoraDto.getGastoEReparaciones())
                .gastoEManiobras(bitacoraDto.getGastoEManiobras())
                .gastoETransito(bitacoraDto.getGastoETransito())
                .gastoEOtros(bitacoraDto.getGastoEOtros())
                .subTotalE(bitacoraDto.getSubTotalE())
                .granTotal(bitacoraDto.getGranTotal())
                .telefonoAdmin(bitacoraDto.getTelefonoAdmin())
                .telefono(bitacoraDto.getTelefono())
                .confirmacion(bitacoraDto.getConfirmacion())
                .liquidacion(bitacoraDto.getLiquidacion() != null ? Liquidacion.builder().idFolio(bitacoraDto.getLiquidacion()).build() : null)
                .build();

        Bitacora saved = bitacoraService.save(b);

        return ResponseEntity.ok(BitacoraDto.builder()
                .idFolio(saved.getIdFolio())
                .fecha(saved.getFecha())
                .operador(saved.getOperador())
                .unidadEco(saved.getUnidadEco())
                .cliente(saved.getCliente())
                .destino(saved.getDestino())
                .ayudantes(saved.getAyudantes())
                .odometroInicial(saved.getOdometroInicial())
                .odometroFinal(saved.getOdometroFinal())
                .distanciaTotal(saved.getDistanciaTotal())
                .combustibleConsumido(saved.getCombustibleConsumido())
                .gastoTCombustible(saved.getGastoTCombustible())
                .gastoTCasetas(saved.getGastoTCasetas())
                .subTotalT(saved.getSubTotalT())
                .gastoECombustible(saved.getGastoECombustible())
                .gastoECasetas(saved.getGastoECasetas())
                .gastoEComida(saved.getGastoEComida())
                .gastoEReparaciones(saved.getGastoEReparaciones())
                .gastoEManiobras(saved.getGastoEManiobras())
                .gastoETransito(saved.getGastoETransito())
                .gastoEOtros(saved.getGastoEOtros())
                .subTotalE(saved.getSubTotalE())
                .granTotal(saved.getGranTotal())
                .telefonoAdmin(saved.getTelefonoAdmin())
                .telefono(saved.getTelefono())
                .confirmacion(saved.getConfirmacion())
                .liquidacion(saved.getLiquidacion() != null ? saved.getLiquidacion().getIdFolio() : null)
                .build());
    }

    @DeleteMapping("/bitacora/{idFolio}")
    public ResponseEntity<Void> delete(@PathVariable Integer idFolio) {
        bitacoraService.delete(idFolio);
        return ResponseEntity.ok().build();
    }
}