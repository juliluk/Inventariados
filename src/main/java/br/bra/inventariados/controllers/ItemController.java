package br.bra.inventariados.controllers;

import br.bra.inventariados.entities.Item;
import br.bra.inventariados.services.ItemService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    //GET - ALL
    @GetMapping(path = "/getAll", produces = "application/json")
    @ApiResponse(description = "getAll")
    @ExceptionHandler(RuntimeException.class)
    public Page<Item> getAll(){

        return itemService.findAll();

    }

    //POST
    @PostMapping(path = "/save", produces = "application/json")
    @ApiResponse(description = "save")
    @ExceptionHandler(RuntimeException.class)
    public Item save(@RequestBody Item item){

        return itemService.save(item);

    }

    //GET - Por ID
    @GetMapping(path = "/findById/{id}", produces = "application/json")
    @ApiResponse(description = "findById")
    @ExceptionHandler(RuntimeException.class)
    public Optional<Item> save(@PathVariable("id") Long itemId){

        return itemService.findById(itemId);

    }

    //PUT
    @PutMapping(path = "/update", produces = "application/json")
    @ApiResponse(description = "update")
    @ExceptionHandler(RuntimeException.class)
    public Item update(@RequestBody Item item) {
        return itemService.save(item);
    }

    //DELETE
    @DeleteMapping(path = "/delete/{id}")
    @ApiResponse(description = "delete")
    @ExceptionHandler(RuntimeException.class)
    public void delete(@PathVariable("id") Long itemId){

        Optional<Item> item = itemService.findById(itemId);
        if(item.isPresent()) {
            Item nitem = item.get();
            itemService.delete(nitem);
        }

    }

}
