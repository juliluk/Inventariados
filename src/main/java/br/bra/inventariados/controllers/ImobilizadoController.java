package br.bra.inventariados.controllers;

import br.bra.inventariados.dto.ImobilizadoDto;
import br.bra.inventariados.entities.Imobilizado;
import br.bra.inventariados.services.ImobilizadoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/imobilizado")
@RequiredArgsConstructor
public class ImobilizadoController {
    private final ImobilizadoService imobilizadoService;

    //GET - ALL
    @GetMapping(path = "/getAll", produces = "application/json")
    @ApiResponse(description = "getAll")
    public Page<Imobilizado> getAll(){
        try {
            return imobilizadoService.findAll();
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //POST
    @PostMapping(path = "/save", produces = "application/json")
    @ApiResponse(description = "save")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    public Imobilizado save(@RequestBody ImobilizadoDto imobilizadoDto){

        try {
            Imobilizado imobilizado = imobilizadoDto.toEntity();
            return imobilizadoService.save(imobilizado);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //GET - Por ID
    @GetMapping(path = "/findById/{id}", produces = "application/json")
    @ApiResponse(description = "findById")
    public Optional<Imobilizado> save(@PathVariable("id") Long imobilizadoId){
        try {
            return imobilizadoService.findById(imobilizadoId);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //PUT
    @PutMapping(path = "/update", produces = "application/json")
    @ApiResponse(description = "update")
    public Imobilizado update(@RequestBody ImobilizadoDto imobilizadoDto){
        try {
            Imobilizado imobilizado = imobilizadoDto.toEntity();
            return imobilizadoService.save(imobilizado);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //DELETE
    @DeleteMapping(path = "/delete/{id}")
    @ApiResponse(description = "delete")
    public void delete(@PathVariable("id") Long imobilizadoId){
        try {

            Optional<Imobilizado> imobilizado = imobilizadoService.findById(imobilizadoId);
            if(imobilizado.isPresent()) {
                Imobilizado nimobilizado = imobilizado.get();
                imobilizadoService.delete(nimobilizado);
            }
        }
        catch(Exception exception)
        {
            return;
        }
    }

}
