package br.bra.inventariados.entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Table(name = "TbItem")
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;
}
