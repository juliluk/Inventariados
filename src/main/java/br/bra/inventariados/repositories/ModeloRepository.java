package br.bra.inventariados.repositories;

import br.bra.inventariados.entities.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, String> {

    @Query(
            value = "select * from tb_modelo c where c.id = ?1",
            nativeQuery = true)
    Optional<Modelo> findModeloById(Long id);

}
