package br.bra.inventariados.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "TbImobilizado")
@Entity
public class Imobilizado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "localizacao_id")
    private Long idLocalizacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "localizacao_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Localizacao localizacao;


    @Column(name = "item_id")
    private Long idItem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Item item;

    @Column(name = "tipo_id")
    private Long idTipo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Tipo tipo;

    @Column(name = "modelo_id")
    private Long idModelo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "modelo_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Modelo modelo;

    @Column(name = "marca_id")
    private Long idMarca;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marca_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Marca marca;

    @Column(name = "localizacao_fisica_id")
    private Long idLocalizacaoFisica;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "localizacao_fisica_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Localizacao localizacaoFisica;

    @Column(name = "acao_id")
    private Long idAcao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "acao_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Acao acao;

    @Column(name = "localizacao_fisica_juncao_id")
    private Long idLocalizacaoFisicaJuncao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "localizacao_fisica_juncao_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Localizacao localizacaoFisicaJuncao;


    /*--*/

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
