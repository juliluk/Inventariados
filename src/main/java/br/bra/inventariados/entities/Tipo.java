package br.bra.inventariados.entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Table(name = "TbTipo")
@Entity
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;
}
