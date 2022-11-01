package br.bra.inventariados.payloads;

import br.bra.inventariados.entities.Acao;
import lombok.Data;

@Data
public class AcaoReponse {

    private Acao acao;
    private Long count;

    public AcaoReponse(Acao acao, Long count){
        this.acao = acao;
        this.count = count;
    }
}
