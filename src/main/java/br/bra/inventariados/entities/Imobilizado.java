package br.bra.inventariados.entities;

import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "TbImobilizado")
@Entity
public class Imobilizado {
    @Id
    @Column(name = "idImobilizado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImobilizado;

    @ManyToOne
    private Localizacao localizacao;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Tipo tipo;

    @ManyToOne
    private Modelo modelo;

    @ManyToOne
    private Marca marca;

    @ManyToOne
    private Localizacao localizacaoFisica;

    @ManyToOne
    private Acao acao;

    @ManyToOne
    private Localizacao localizacaoFisicaJuncao;

    /*
    @ManyToOne
    @JoinTable(name = "TbLocalizacao", joinColumns = @JoinColumn(name = "idLocalizacao", referencedColumnName = "idLocalizacao"),
            inverseJoinColumns = @JoinColumn(name = "idLocalizacao", referencedColumnName = "idLocalizacao"))
    private Localizacao localizacao;
    */

    /*
    @ManyToOne
    @JoinTable(name = "TbItem", joinColumns = @JoinColumn(name = "idItem", referencedColumnName = "idItem"),
            inverseJoinColumns = @JoinColumn(name = "idItem", referencedColumnName = "idItem"))
    private Item item;

    @ManyToOne
    @JoinTable(name = "TbTipo", joinColumns = @JoinColumn(name = "idTipo", referencedColumnName = "idTipo"),
            inverseJoinColumns = @JoinColumn(name = "idTipo", referencedColumnName = "idTipo"))
    private Tipo tipo;

    @ManyToOne
    @JoinTable(name = "TbModelo", joinColumns = @JoinColumn(name = "idModelo", referencedColumnName = "idModelo"),
            inverseJoinColumns = @JoinColumn(name = "idModelo", referencedColumnName = "idModelo"))
    private Modelo modelo;

    @ManyToOne
    @JoinTable(name = "TbMarca", joinColumns = @JoinColumn(name = "idMarca", referencedColumnName = "idMarca"),
            inverseJoinColumns = @JoinColumn(name = "idMarca", referencedColumnName = "idMarca"))
    private Marca marca;
    */

    /*
    @ManyToOne
    @JoinTable(name = "TbLocalizacao", joinColumns = @JoinColumn(name = "idLocalizacaoFisica", referencedColumnName = "idLocalizacao"),
            inverseJoinColumns = @JoinColumn(name = "idLocalizacaoFisica", referencedColumnName = "idLocalizacao"))
    private Localizacao localizacaoFisica;
    */

        /*
    @ManyToOne
    @JoinTable(name = "TbAcao", joinColumns = @JoinColumn(name = "idAcao", referencedColumnName = "idAcao"),
            inverseJoinColumns = @JoinColumn(name = "idAcao", referencedColumnName = "idAcao"))
    private Acao acao;

    @ManyToOne
    @JoinTable(name = "TbLocalizacao", joinColumns = @JoinColumn(name = "idLocalizacaoFisicaJuncao", referencedColumnName = "idLocalizacao"),
            inverseJoinColumns = @JoinColumn(name = "idLocalizacaoFisicaJuncao", referencedColumnName = "idLocalizacao"))
    private Localizacao localizacaoFisicaJuncao;

    */

    @Column(name = "nrSerieSap")
    private String nrSerieSap;

    @Column(name = "IMEI")
    private String Imei;

    @Column(name = "dtAquisicao")
    private LocalDateTime dtAquisicao;

    @Column(name = "nrDocumento")
    private String nrDocumento;

    @Column(name = "dtTransferencia")
    private LocalDateTime dtTransferencia;

    @Column(name = "vlAquisicao")
    private Double vlAquisicao;

    @Column(name = "vlDepreciacaoAcumulada")
    private Double vlDepreciacaoAcumulada;

    @Column(name = "vlContabil")
    private Double vlContabil;

    @Column(name = "nrPedido")
    private String nrPedido;

    @Column(name = "nrContrato")
    private String nrContrato;

    @Column(name = "blExisteFisicamente")
    private Boolean blExisteFisicamente;


    @Column(name = "nrSerieEquipamentoFisico")
    private String nrSerieEquipamentoFisico;

    @Column(name = "blJustificativa")
    private Boolean blJustificativa;


    @Column(name = "observacao")
    private String observacao;

    @Column(name = "nrCodigoFuncional")
    private String nrCodigoFuncional;

    @Column(name = "dtReportImobilizado")
    private LocalDateTime dtReportImobilizado;

}
