package br.bra.inventariados.services;


import br.bra.inventariados.entities.Tipo;
import br.bra.inventariados.repositories.TipoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoService {

    private final TipoRepository tipoRepository;

    public Page<Tipo> findAll() throws RuntimeException{

        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "descricao");
        return new PageImpl<>(
                tipoRepository.findAll(),
                pageRequest, size);

    }

    public Tipo save(Tipo tipo) throws RuntimeException{

        return tipoRepository.save(tipo);

    }

    public void delete(Tipo tipo) throws RuntimeException{

        tipoRepository.delete(tipo);

    }

    public Optional<Tipo> findById(Long id) throws RuntimeException{

       return tipoRepository.findTipoById(id);

    }

}
