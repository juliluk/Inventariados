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
    @ExceptionHandler(RuntimeException.class)
    public Page<Tipo> getAll(){

        return tipoService.findAll();

    }

    //POST
    @PostMapping(path = "/save", produces = "application/json")
    @ApiResponse(description = "save")
    @ExceptionHandler(RuntimeException.class)
    public Tipo save(@RequestBody Tipo tipo){

        return tipoService.save(tipo);

    }

    //GET - Por ID
    @GetMapping(path = "/findById/{id}", produces = "application/json")
    @ApiResponse(description = "findById")
    @ExceptionHandler(RuntimeException.class)
    public Optional<Tipo> save(@PathVariable("id") Long tipoId){

        return tipoService.findById(tipoId);

    }

    //PUT
    @PutMapping(path = "/update", produces = "application/json")
    @ApiResponse(description = "update")
    @ExceptionHandler(RuntimeException.class)
    public Tipo update(@RequestBody Tipo tipo){

        return tipoService.save(tipo);

    }

    //DELETE
    @DeleteMapping(path = "/delete/{id}")
    @ApiResponse(description = "delete")
    @ExceptionHandler(RuntimeException.class)
    public void delete(@PathVariable("id") Long tipoId){

        Optional<Tipo> tipo = tipoService.findById(tipoId);
        if(tipo.isPresent()) {
            Tipo ntipo = tipo.get();
            tipoService.delete(ntipo);
        }

    }

}
