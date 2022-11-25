package br.bra.inventariados.services;


import br.bra.inventariados.entities.Marca;
import br.bra.inventariados.repositories.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public Page<Marca> findAll() throws RuntimeException{

        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "descricao");
        return new PageImpl<>(
                marcaRepository.findAll(),
                pageRequest, size);

    }

    public Marca save(Marca marca) throws RuntimeException{

        return marcaRepository.save(marca);

    }

    public void delete(Marca marca) throws RuntimeException{

        marcaRepository.delete(marca);

    }

    public Optional<Marca> findById(Long id) throws RuntimeException{

       return marcaRepository.findMarcaById(id);

    }

}
