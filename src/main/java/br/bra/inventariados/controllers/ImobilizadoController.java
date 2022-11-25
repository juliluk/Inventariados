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
    @ExceptionHandler(RuntimeException.class)
    public Page<Imobilizado> getAll(){
        return imobilizadoService.findAll();
    }

    //POST
    @PostMapping(path = "/save", produces = "application/json")
    @ApiResponse(description = "save")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @ExceptionHandler(RuntimeException.class)
    public Imobilizado save(@RequestBody ImobilizadoDto imobilizadoDto){

        Imobilizado imobilizado = imobilizadoDto.toEntity();
        return imobilizadoService.save(imobilizado);

    }

    //GET - Por ID
    @GetMapping(path = "/findById/{id}", produces = "application/json")
    @ApiResponse(description = "findById")
    @ExceptionHandler(RuntimeException.class)
    public Optional<Imobilizado> save(@PathVariable("id") Long imobilizadoId){
        return imobilizadoService.findById(imobilizadoId);

    }

    //PUT
    @PutMapping(path = "/update", produces = "application/json")
    @ApiResponse(description = "update")
    @ExceptionHandler(RuntimeException.class)
    public Imobilizado update(@RequestBody ImobilizadoDto imobilizadoDto){
        Imobilizado imobilizado = imobilizadoDto.toEntity();
        return imobilizadoService.save(imobilizado);

    }

    //DELETE
    @DeleteMapping(path = "/delete/{id}")
    @ApiResponse(description = "delete")
    @ExceptionHandler(RuntimeException.class)
    public void delete(@PathVariable("id") Long imobilizadoId){

        Optional<Imobilizado> imobilizado = imobilizadoService.findById(imobilizadoId);
        if(imobilizado.isPresent()) {
            Imobilizado nimobilizado = imobilizado.get();
            imobilizadoService.delete(nimobilizado);
        }

    }



}
