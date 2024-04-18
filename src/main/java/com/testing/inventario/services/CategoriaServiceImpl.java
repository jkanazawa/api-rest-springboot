package com.testing.inventario.services;

import com.testing.inventario.entities.dto.CategoriaDTO;
import com.testing.inventario.entities.model.Categoria;
import com.testing.inventario.exceptions.ResourceNotFoundException;
import com.testing.inventario.repositories.CategoriaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;



@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;


    @Override
    public CategoriaDTO getById(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría con ID " + id + " no encontrada"));
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNombre(categoria.getNombre());
        return categoriaDTO;
    }

    @Override
    public void create(CategoriaDTO categoriaRequest) {
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaRequest.getNombre());
        categoriaRepository.save(categoria);
    }

    @Override
    public void update(Long id, CategoriaDTO categoriaRequest) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isPresent()) {
            Categoria categoria = categoriaOptional.get();
            categoria.setNombre(categoriaRequest.getNombre());
            categoriaRepository.save(categoria);
        } else {
            throw new ResourceNotFoundException("Categoría con ID " + id + " no encontrada");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isPresent()) {
            categoriaRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Categoría con ID " + id + " no encontrada");
        }
    }
}
