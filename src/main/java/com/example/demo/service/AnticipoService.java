package com.example.demo.service;

import com.example.demo.model.Anticipo;
import java.util.List;

public interface AnticipoService {
    List<Anticipo> getAll();
    Anticipo getByIdFolio(String idFolio);
    Anticipo save(Anticipo anticipo);
    void delete(String idFolio);
}