package br.bra.inventariados.entities;

import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "TbModelo")
@Entity
public class Modelo {
    @Id
    @Column(name = "idModelo")
    private Long idModelo;
    @Column(name = "descricao")
    private String descricao;
}
