package br.bra.inventariados.controllers;

import br.bra.inventariados.entities.Acao;
import br.bra.inventariados.payloads.AcaoReponse;
import br.bra.inventariados.payloads.AcaoRequest;
import br.bra.inventariados.services.AcaoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acao")
@RequiredArgsConstructor
public class AcaoController {

    private final AcaoService acaoService;

    @GetMapping(path = "/getAll", produces = "application/json")
    @ApiResponse(description = "acao")
    public Page<Acao> getAll(){
        try {
            return acaoService.findAll();
        }
        catch(Exception exception)
        {
            return null;
        }
    }

}
