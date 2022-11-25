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
    @ExceptionHandler(RuntimeException.class)
    public Page<Localizacao> getAll(){

        return localizacaoService.findAll();

    }

    //POST
    @PostMapping(path = "/save", produces = "application/json")
    @ApiResponse(description = "save")
    @ExceptionHandler(RuntimeException.class)
    public Localizacao save(@RequestBody Localizacao localizacao){

        return localizacaoService.save(localizacao);

    }

    //GET - Por ID
    @GetMapping(path = "/findById/{id}", produces = "application/json")
    @ApiResponse(description = "findById")
    @ExceptionHandler(RuntimeException.class)
    public Optional<Localizacao> save(@PathVariable("id") Long localizacaoId){

        return localizacaoService.findById(localizacaoId);

    }

    //PUT
    @PutMapping(path = "/update", produces = "application/json")
    @ApiResponse(description = "update")
    @ExceptionHandler(RuntimeException.class)
    public Localizacao update(@RequestBody Localizacao localizacao){

        return localizacaoService.save(localizacao);

    }

    //DELETE
    @DeleteMapping(path = "/delete/{id}")
    @ApiResponse(description = "delete")
    @ExceptionHandler(RuntimeException.class)
    public void delete(@PathVariable("id") Long localizacaoId){

        Optional<Localizacao> localizacao = localizacaoService.findById(localizacaoId);
        if(localizacao.isPresent()) {
            Localizacao nlocalizacao = localizacao.get();
            localizacaoService.delete(nlocalizacao);
        }

    }

}
