package com.testing.inventario.services;

import com.testing.inventario.entities.dto.CategoriaDTO;
import com.testing.inventario.entities.model.Categoria;

public interface CategoriaService {

    CategoriaDTO getById(Long id);
    void create(CategoriaDTO categoriaRequest);

    void update(Long id, CategoriaDTO categoriaRequest);

    void delete(Long id);

}
