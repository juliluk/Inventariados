package br.bra.inventariados.services;


import br.bra.inventariados.entities.Localizacao;
import br.bra.inventariados.repositories.LocalizacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocalizacaoService {

    private final LocalizacaoRepository localizacaoRepository;

    public Page<Localizacao> findAll() throws RuntimeException{

        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "descricao");
        return new PageImpl<>(
                localizacaoRepository.findAll(),
                pageRequest, size);

    }

    public Localizacao save(Localizacao localizacao) throws RuntimeException{

        return localizacaoRepository.save(localizacao);

    }

    public void delete(Localizacao localizacao) throws RuntimeException{

        localizacaoRepository.delete(localizacao);

    }

    public Optional<Localizacao> findById(Long id) throws RuntimeException{

       return localizacaoRepository.findLocalizacaoById(id);

    }

}
