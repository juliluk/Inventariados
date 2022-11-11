package br.bra.inventariados.repositories;

import br.bra.inventariados.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

    @Query(
            value = "select * from tb_item c where c.id = ?1",
            nativeQuery = true)
    Optional<Item> findItemById(Long id);

}
