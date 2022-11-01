package br.bra.inventariados.entities;


import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "TbMarca")
@Entity
public class Marca {
    @Id
    @Column(name = "idMarca")
    private Long idMarca;
    @Column(name = "descricao")
    private String descricao;
}
