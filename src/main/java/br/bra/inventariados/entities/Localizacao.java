package br.bra.inventariados.entities;

import lombok.Data;


import javax.persistence.*;
import java.math.BigInteger;

@Data
@Table(name = "TbLocalizacao")
@Entity
public class Localizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLocalizacao")
    private Long idLocalizacao;
    @Column(name = "descricao")
    private String descricao;
}
