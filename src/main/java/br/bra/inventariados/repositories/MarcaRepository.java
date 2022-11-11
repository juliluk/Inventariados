package br.bra.inventariados.repositories;

import br.bra.inventariados.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, String> {

    @Query(
            value = "select * from tb_marca c where c.id = ?1",
            nativeQuery = true)
    Optional<Marca> findMarcaById(Long id);

}
