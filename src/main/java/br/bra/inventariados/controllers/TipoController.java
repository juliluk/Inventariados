package br.bra.inventariados.controllers;

import br.bra.inventariados.entities.Tipo;
import br.bra.inventariados.services.TipoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/tipo")
@RequiredArgsConstructor
public class TipoController {

    private final TipoService tipoService;

    //GET - ALL
    @GetMapping(path = "/getAll", produces = "application/json")
    @ApiResponse(description = "getAll")
    public Page<Tipo> getAll(){
        try {
            return tipoService.findAll();
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //POST
    @PostMapping(path = "/save", produces = "application/json")
    @ApiResponse(description = "save")
    public Tipo save(@RequestBody Tipo tipo){
        try {
            return tipoService.save(tipo);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //GET - Por ID
    @GetMapping(path = "/findById/{id}", produces = "application/json")
    @ApiResponse(description = "findById")
    public Optional<Tipo> save(@PathVariable("id") Long tipoId){
        try {
            return tipoService.findById(tipoId);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //PUT
    @PutMapping(path = "/update", produces = "application/json")
    @ApiResponse(description = "update")
    public Tipo update(@RequestBody Tipo tipo){
        try {
            return tipoService.save(tipo);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //DELETE
    @DeleteMapping(path = "/delete/{id}")
    @ApiResponse(description = "delete")
    public void delete(@PathVariable("id") Long tipoId){
        try {

            Optional<Tipo> tipo = tipoService.findById(tipoId);
            if(tipo.isPresent()) {
                Tipo ntipo = tipo.get();
                tipoService.delete(ntipo);
            }
        }
        catch(Exception exception)
        {
            return;
        }
    }

}
