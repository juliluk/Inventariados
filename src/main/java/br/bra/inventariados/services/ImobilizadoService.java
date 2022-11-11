package br.bra.inventariados.services;


import br.bra.inventariados.entities.Imobilizado;
import br.bra.inventariados.repositories.ImobilizadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImobilizadoService {

    private final ImobilizadoRepository imobilizadoRepository;

    public Page<Imobilizado> findAll(){

        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "descricao");
        return new PageImpl<>(
                imobilizadoRepository.findAll(),
                pageRequest, size);

    }

    public Imobilizado save(Imobilizado imobilizado){

        return imobilizadoRepository.save(imobilizado);

    }

    public void delete(Imobilizado imobilizado){

        imobilizadoRepository.delete(imobilizado);

    }

    public Optional<Imobilizado> findById(Long id){

       try{
           return imobilizadoRepository.findImobilizadoById(id);
       }catch (Exception ex){
           return null;
       }

    }

}
