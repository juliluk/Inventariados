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
    @ExceptionHandler(RuntimeException.class)
    public Page<Modelo> getAll(){

        return modeloService.findAll();

    }

    //POST
    @PostMapping(path = "/save", produces = "application/json")
    @ApiResponse(description = "save")
    @ExceptionHandler(RuntimeException.class)
    public Modelo save(@RequestBody Modelo modelo){

        return modeloService.save(modelo);

    }

    //GET - Por ID
    @GetMapping(path = "/findById/{id}", produces = "application/json")
    @ApiResponse(description = "findById")
    @ExceptionHandler(RuntimeException.class)
    public Optional<Modelo> save(@PathVariable("id") Long modeloId){

        return modeloService.findById(modeloId);

    }

    //PUT
    @PutMapping(path = "/update", produces = "application/json")
    @ApiResponse(description = "update")
    @ExceptionHandler(RuntimeException.class)
    public Modelo update(@RequestBody Modelo modelo){

        return modeloService.save(modelo);

    }

    //DELETE
    @DeleteMapping(path = "/delete/{id}")
    @ApiResponse(description = "delete")
    @ExceptionHandler(RuntimeException.class)
    public void delete(@PathVariable("id") Long modeloId){

        Optional<Modelo> modelo = modeloService.findById(modeloId);
        if(modelo.isPresent()) {
            Modelo nmodelo = modelo.get();
            modeloService.delete(nmodelo);
        }

    }

}
