package com.example.demo.service.impl;

import com.example.demo.model.Bitacora;
import com.example.demo.repository.BitacoraRepository;
import com.example.demo.service.BitacoraService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BitacoraServiceImpl implements BitacoraService {

    private final BitacoraRepository bitacoraRepository;

    @Override
    public List<Bitacora> getAll() {
        return bitacoraRepository.findAll();
    }

    @Override
    public Bitacora getByIdFolio(Integer idFolio) {
        return bitacoraRepository.findById(idFolio).orElse(null);
    }

    @Override
    public Bitacora save(Bitacora bitacora) {
        return bitacoraRepository.save(bitacora);
    }

    @Override
    public void delete(Integer idFolio) {
        bitacoraRepository.deleteById(idFolio);
    }
}