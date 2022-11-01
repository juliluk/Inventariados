package br.bra.inventariados.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "TbItem")
@Entity
public class Item {
    @Id
    @Column(name = "idItem")
    private Long idItem;
    @Column(name = "descricao")
    private String descricao;
}
