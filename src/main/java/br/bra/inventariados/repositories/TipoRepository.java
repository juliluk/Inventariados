package br.bra.inventariados.repositories;

import br.bra.inventariados.entities.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, String> {

    @Query(
            value = "select * from tb_tipo c where c.id = ?1",
            nativeQuery = true)
    Optional<Tipo> findTipoById(Long id);

}
