package com.testing.inventario.services;

import com.testing.inventario.entities.dto.CategoriaDTO;
import com.testing.inventario.entities.dto.MarcaDTO;

public interface MarcaService {

    MarcaDTO getById(Long id);
    void create(MarcaDTO marcaRequest);

    void update(Long id, MarcaDTO marcaRequest);

    void delete(Long id);

}
