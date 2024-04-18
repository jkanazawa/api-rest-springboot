package com.testing.inventario.services;

import com.testing.inventario.entities.dto.MarcaDTO;
import com.testing.inventario.entities.dto.ProductoDTO;

public interface ProductoService {

    ProductoDTO getById(Long id);
    void create(ProductoDTO productoDTO);

    void update(Long id, ProductoDTO productoDTO);

    void delete(Long id);

}
