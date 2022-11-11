package br.bra.inventariados.controllers;

import br.bra.inventariados.entities.Acao;
import br.bra.inventariados.services.AcaoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/acao")
@RequiredArgsConstructor
public class AcaoController {

    private final AcaoService acaoService;

    //GET - ALL
    @GetMapping(path = "/getAll", produces = "application/json")
    @ApiResponse(description = "getAll")
    public Page<Acao> getAll(){
        try {
            return acaoService.findAll();
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //POST
    @PostMapping(path = "/save", produces = "application/json")
    @ApiResponse(description = "save")
    public Acao save(@RequestBody Acao acao){
        try {
            return acaoService.save(acao);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //GET - Por ID
    @GetMapping(path = "/findById/{id}", produces = "application/json")
    @ApiResponse(description = "findById")
    public Optional<Acao> save(@PathVariable("id") Long acaoId){
        try {
            return acaoService.findById(acaoId);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //PUT
    @PutMapping(path = "/update", produces = "application/json")
    @ApiResponse(description = "update")
    public Acao update(@RequestBody Acao acao){
        try {
            return acaoService.save(acao);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //DELETE
    @DeleteMapping(path = "/delete/{id}")
    @ApiResponse(description = "delete")
    public void delete(@PathVariable("id") Long acaoId){
        try {

            Optional<Acao> acao = acaoService.findById(acaoId);
            if(acao.isPresent()) {
                Acao nacao = acao.get();
                acaoService.delete(nacao);
            }
        }
        catch(Exception exception)
        {
            return;
        }
    }

}
