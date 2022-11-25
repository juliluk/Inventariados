package br.bra.inventariados.entities;

/*package br.bra.inventariados.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "TbAcao")
@Entity
public class Acao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "descricao")
    private String descricao;
}
*/


public enum Acao {
    TRANSFERIR(1),
    BAIXAR(2),
    NENHUMA(3);

    private Integer id;
    Acao(Integer id) {
        this.id = id;
    }
}