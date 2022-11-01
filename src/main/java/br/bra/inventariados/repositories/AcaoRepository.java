package br.bra.inventariados.repositories;

import br.bra.inventariados.entities.Acao;
import br.bra.inventariados.payloads.AcaoReponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, String> {

}
