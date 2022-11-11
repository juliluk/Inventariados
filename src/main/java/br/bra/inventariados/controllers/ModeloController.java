package br.bra.inventariados.controllers;

import br.bra.inventariados.entities.Modelo;
import br.bra.inventariados.services.ModeloService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/modelo")
@RequiredArgsConstructor
public class ModeloController {
    private final ModeloService modeloService;

    //GET - ALL
    @GetMapping(path = "/getAll", produces = "application/json")
    @ApiResponse(description = "getAll")
    public Page<Modelo> getAll(){
        try {
            return modeloService.findAll();
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //POST
    @PostMapping(path = "/save", produces = "application/json")
    @ApiResponse(description = "save")
    public Modelo save(@RequestBody Modelo modelo){
        try {
            return modeloService.save(modelo);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //GET - Por ID
    @GetMapping(path = "/findById/{id}", produces = "application/json")
    @ApiResponse(description = "findById")
    public Optional<Modelo> save(@PathVariable("id") Long modeloId){
        try {
            return modeloService.findById(modeloId);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //PUT
    @PutMapping(path = "/update", produces = "application/json")
    @ApiResponse(description = "update")
    public Modelo update(@RequestBody Modelo modelo){
        try {
            return modeloService.save(modelo);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //DELETE
    @DeleteMapping(path = "/delete/{id}")
    @ApiResponse(description = "delete")
    public void delete(@PathVariable("id") Long modeloId){
        try {

            Optional<Modelo> modelo = modeloService.findById(modeloId);
            if(modelo.isPresent()) {
                Modelo nmodelo = modelo.get();
                modeloService.delete(nmodelo);
            }
        }
        catch(Exception exception)
        {
            return;
        }
    }

}
