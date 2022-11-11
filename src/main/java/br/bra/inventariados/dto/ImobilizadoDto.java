package br.bra.inventariados.dto;


import br.bra.inventariados.entities.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@Data
public class ImobilizadoDto {

    private Long idImobilizado;
    private Long idItem;
    private Long idTipo;
    private Long idModelo;
    private Long idMarca;
    private Long idAcao;
    private Long idLocalizacao;
    private Long idLocalizacaoFisica;
    private Long idLocalizacaoFisicaJuncao;
    private String nrSerieSap;
    private String Imei;
    private String dtAquisicao;
    private String nrDocumento;
    private String dtTransferencia;
    private Double vlAquisicao;
    private Double vlDepreciacaoAcumulada;
    private Double vlContabil;
    private String nrPedido;
    private String nrContrato;
    private Boolean blExisteFisicamente;
    private String nrSerieEquipamentoFisico;
    private Boolean blJustificativa;
    private String observacao;
    private String nrCodigoFuncional;
    private String dtReportImobilizado;
    public Imobilizado toEntity() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Imobilizado entity = new Imobilizado();
        entity.setId(this.idImobilizado);
        entity.setIdLocalizacao(this.idLocalizacao);
        entity.setIdLocalizacaoFisica(this.idLocalizacaoFisica);
        entity.setIdLocalizacaoFisicaJuncao(this.idLocalizacaoFisicaJuncao);
        entity.setIdItem(this.idItem);
        entity.setIdTipo(this.idTipo);
        entity.setIdModelo(this.idModelo);
        entity.setIdMarca(this.idMarca);
        entity.setIdAcao(this.idAcao);
        entity.setNrSerieSap(this.nrSerieSap);
        entity.setImei(this.Imei);

        LocalDate ld = LocalDate.parse(this.dtAquisicao, dtf);
        LocalDateTime ldt = LocalDateTime.of(ld, LocalTime.of(0,0));
        entity.setDtAquisicao(ldt);
        entity.setNrDocumento(this.nrDocumento);

        ld = LocalDate.parse(this.dtTransferencia, dtf);
        ldt = LocalDateTime.of(ld, LocalTime.of(0,0));
        entity.setDtTransferencia(ldt);

        entity.setVlAquisicao(this.vlAquisicao);
        entity.setVlDepreciacaoAcumulada(this.vlDepreciacaoAcumulada);
        entity.setVlContabil(this.vlContabil);
        entity.setNrPedido(this.nrPedido);
        entity.setNrContrato(this.nrContrato);
        entity.setBlExisteFisicamente(this.blExisteFisicamente);
        entity.setNrSerieEquipamentoFisico(this.nrSerieEquipamentoFisico);
        entity.setBlJustificativa(this.blJustificativa);
        entity.setObservacao(this.observacao);
        entity.setNrCodigoFuncional(this.nrCodigoFuncional);

        ld = LocalDate.parse(this.dtReportImobilizado, dtf);
        ldt = LocalDateTime.of(ld, LocalTime.of(0,0));
        entity.setDtReportImobilizado(ldt);

        return entity;
    }

}
