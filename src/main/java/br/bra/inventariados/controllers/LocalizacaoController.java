package br.bra.inventariados.controllers;

import br.bra.inventariados.entities.Localizacao;
import br.bra.inventariados.services.LocalizacaoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/localizacao")
@RequiredArgsConstructor
public class LocalizacaoController {
    private final LocalizacaoService localizacaoService;

    //GET - ALL
    @GetMapping(path = "/getAll", produces = "application/json")
    @ApiResponse(description = "getAll")
    public Page<Localizacao> getAll(){
        try {
            return localizacaoService.findAll();
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //POST
    @PostMapping(path = "/save", produces = "application/json")
    @ApiResponse(description = "save")
    public Localizacao save(@RequestBody Localizacao localizacao){
        try {
            return localizacaoService.save(localizacao);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //GET - Por ID
    @GetMapping(path = "/findById/{id}", produces = "application/json")
    @ApiResponse(description = "findById")
    public Optional<Localizacao> save(@PathVariable("id") Long localizacaoId){
        try {
            return localizacaoService.findById(localizacaoId);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //PUT
    @PutMapping(path = "/update", produces = "application/json")
    @ApiResponse(description = "update")
    public Localizacao update(@RequestBody Localizacao localizacao){
        try {
            return localizacaoService.save(localizacao);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //DELETE
    @DeleteMapping(path = "/delete/{id}")
    @ApiResponse(description = "delete")
    public void delete(@PathVariable("id") Long localizacaoId){
        try {

            Optional<Localizacao> localizacao = localizacaoService.findById(localizacaoId);
            if(localizacao.isPresent()) {
                Localizacao nlocalizacao = localizacao.get();
                localizacaoService.delete(nlocalizacao);
            }
        }
        catch(Exception exception)
        {
            return;
        }
    }

}
