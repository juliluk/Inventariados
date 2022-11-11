package br.bra.inventariados.services;

import br.bra.inventariados.entities.Item;
import br.bra.inventariados.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Page<Item> findAll(){

        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "descricao");
        return new PageImpl<>(
                itemRepository.findAll(),
                pageRequest, size);

    }

    public Item save(Item item){

        return itemRepository.save(item);

    }

    public void delete(Item item){

        itemRepository.delete(item);

    }

    public Optional<Item> findById(Long id){

       try{
           return itemRepository.findItemById(id);
       }catch (Exception ex){
           return null;
       }

    }

}
