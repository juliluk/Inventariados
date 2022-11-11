package br.bra.inventariados.controllers;

import br.bra.inventariados.entities.Marca;
import br.bra.inventariados.services.MarcaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/marca")
@RequiredArgsConstructor
public class MarcaController {
    private final MarcaService marcaService;

    //GET - ALL
    @GetMapping(path = "/getAll", produces = "application/json")
    @ApiResponse(description = "getAll")
    public Page<Marca> getAll(){
        try {
            return marcaService.findAll();
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //POST
    @PostMapping(path = "/save", produces = "application/json")
    @ApiResponse(description = "save")
    public Marca save(@RequestBody Marca marca){
        try {
            return marcaService.save(marca);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //GET - Por ID
    @GetMapping(path = "/findById/{id}", produces = "application/json")
    @ApiResponse(description = "findById")
    public Optional<Marca> save(@PathVariable("id") Long marcaId){
        try {
            return marcaService.findById(marcaId);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //PUT
    @PutMapping(path = "/update", produces = "application/json")
    @ApiResponse(description = "update")
    public Marca update(@RequestBody Marca marca){
        try {
            return marcaService.save(marca);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //DELETE
    @DeleteMapping(path = "/delete/{id}")
    @ApiResponse(description = "delete")
    public void delete(@PathVariable("id") Long marcaId){
        try {

            Optional<Marca> marca = marcaService.findById(marcaId);
            if(marca.isPresent()) {
                Marca nmarca = marca.get();
                marcaService.delete(nmarca);
            }
        }
        catch(Exception exception)
        {
            return;
        }
    }

}
