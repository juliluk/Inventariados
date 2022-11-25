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
    @ExceptionHandler(RuntimeException.class)
    public Page<Marca> getAll(){

        return marcaService.findAll();

    }

    //POST
    @PostMapping(path = "/save", produces = "application/json")
    @ApiResponse(description = "save")
    @ExceptionHandler(RuntimeException.class)
    public Marca save(@RequestBody Marca marca){

        return marcaService.save(marca);

    }

    //GET - Por ID
    @GetMapping(path = "/findById/{id}", produces = "application/json")
    @ApiResponse(description = "findById")
    @ExceptionHandler(RuntimeException.class)
    public Optional<Marca> save(@PathVariable("id") Long marcaId){

        return marcaService.findById(marcaId);

    }

    //PUT
    @PutMapping(path = "/update", produces = "application/json")
    @ApiResponse(description = "update")
    @ExceptionHandler(RuntimeException.class)
    public Marca update(@RequestBody Marca marca){

        return marcaService.save(marca);

    }

    //DELETE
    @DeleteMapping(path = "/delete/{id}")
    @ApiResponse(description = "delete")
    @ExceptionHandler(RuntimeException.class)
    public void delete(@PathVariable("id") Long marcaId){

        Optional<Marca> marca = marcaService.findById(marcaId);
        if(marca.isPresent()) {
            Marca nmarca = marca.get();
            marcaService.delete(nmarca);
        }

    }

}
