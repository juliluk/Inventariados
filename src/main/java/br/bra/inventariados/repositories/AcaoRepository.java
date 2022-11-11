package br.bra.inventariados.repositories;

import br.bra.inventariados.entities.Acao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, String> {

    @Query(
            value = "select * from tb_acao c where c.id = ?1", /* c.id = ?1 recebe o id do parametro */
            nativeQuery = true)
    Optional<Acao> findAcaoById(Long id);

}
