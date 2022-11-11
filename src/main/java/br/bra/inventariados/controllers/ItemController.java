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
    public Page<Item> getAll(){
        try {
            return itemService.findAll();
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //POST
    @PostMapping(path = "/save", produces = "application/json")
    @ApiResponse(description = "save")
    public Item save(@RequestBody Item item){
        try {
            return itemService.save(item);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //GET - Por ID
    @GetMapping(path = "/findById/{id}", produces = "application/json")
    @ApiResponse(description = "findById")
    public Optional<Item> save(@PathVariable("id") Long itemId){
        try {
            return itemService.findById(itemId);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //PUT
    @PutMapping(path = "/update", produces = "application/json")
    @ApiResponse(description = "update")
    public Item update(@RequestBody Item item){
        try {
            return itemService.save(item);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    //DELETE
    @DeleteMapping(path = "/delete/{id}")
    @ApiResponse(description = "delete")
    public void delete(@PathVariable("id") Long itemId){
        try {

            Optional<Item> item = itemService.findById(itemId);
            if(item.isPresent()) {
                Item nitem = item.get();
                itemService.delete(nitem);
            }
        }
        catch(Exception exception)
        {
            return;
        }
    }

}
