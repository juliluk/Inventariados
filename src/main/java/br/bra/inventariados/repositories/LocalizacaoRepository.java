package br.bra.inventariados.repositories;

import br.bra.inventariados.entities.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, String> {

    @Query(
            value = "select * from tb_localizacao c where c.id = ?1",
            nativeQuery = true)
    Optional<Localizacao> findLocalizacaoById(Long id);

}
