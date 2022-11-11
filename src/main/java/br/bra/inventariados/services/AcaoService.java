package br.bra.inventariados.services;

import br.bra.inventariados.entities.Acao;
import br.bra.inventariados.repositories.AcaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcaoService {

    private final AcaoRepository acaoRepository;

    public Page<Acao> findAll(){

        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "descricao");
        return new PageImpl<>(
                acaoRepository.findAll(),
                pageRequest, size);

    }

    public Acao save(Acao acao){

        return acaoRepository.save(acao);

    }

    public void delete(Acao acao){

        acaoRepository.delete(acao);

    }

    public Optional<Acao> findById(Long id){

       try{
           return acaoRepository.findAcaoById(id);
       }catch (Exception ex){
           return null;
       }

    }

}
