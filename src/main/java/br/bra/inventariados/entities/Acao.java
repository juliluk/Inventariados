package br.bra.inventariados.entities;

import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "TbAcao")
@Entity
public class Acao {
    @Id
    @Column(name = "idAcao")
    private Long idAcao;
    @Column(name = "descricao")
    private String descricao;
}
