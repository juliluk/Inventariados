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

    public Page<Marca> findAll(){

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

    public Marca save(Marca marca){

        return marcaRepository.save(marca);

    }

    public void delete(Marca marca){

        marcaRepository.delete(marca);

    }

    public Optional<Marca> findById(Long id){

       try{
           return marcaRepository.findMarcaById(id);
       }catch (Exception ex){
           return null;
       }

    }

}
