package br.bra.inventariados.entities;

import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "TbTipo")
@Entity
public class Tipo {
    @Id
    @Column(name = "idTipo")
    private Long idTipo;
    @Column(name = "descricao")
    private String descricao;
}
