package br.bra.inventariados.services;


import br.bra.inventariados.entities.Modelo;
import br.bra.inventariados.repositories.ModeloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModeloService {

    private final ModeloRepository modeloRepository;

    public Page<Modelo> findAll(){

        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "descricao");
        return new PageImpl<>(
                modeloRepository.findAll(),
                pageRequest, size);

    }

    public Modelo save(Modelo modelo){

        return modeloRepository.save(modelo);

    }

    public void delete(Modelo modelo){

        modeloRepository.delete(modelo);

    }

    public Optional<Modelo> findById(Long id){

       try{
           return modeloRepository.findModeloById(id);
       }catch (Exception ex){
           return null;
       }

    }

}
