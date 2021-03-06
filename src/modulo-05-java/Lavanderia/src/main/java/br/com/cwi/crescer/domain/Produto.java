package br.com.cwi.crescer.domain;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Produto")
@SequenceGenerator(name = Produto.SEQUENCE_NAME, sequenceName = Produto.SEQUENCE_NAME, allocationSize = 1)
public class Produto {

    public static final String SEQUENCE_NAME = "SEQ_Produto";

    @Id
    @Column(name = "IDProduto")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    private Long idProduto;

    @ManyToOne
    @JoinColumn(name = "IDServico")
    @Basic(optional = false)
    private Servico servico;

    @ManyToOne
    @JoinColumn(name = "IDMaterial")
    @Basic(optional = false)
    private Material material;

    @Column(name = "Valor")
    @Basic(optional = false)
    private BigDecimal valorProduto;

    @Column(name = "Prazo")
    private Long prazo;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Situacao", length = 1)
    private SituacaoProduto situacaoProduto;

    public static enum SituacaoProduto {
        ATIVO, INATIVO
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    public Long getPrazo() {
        return prazo;
    }

    public void setPrazo(Long prazo) {
        this.prazo = prazo;
    }

    public SituacaoProduto getSituacaoProduto() {
        return situacaoProduto;
    }

    public void setSituacaoProduto(SituacaoProduto situacaoProduto) {
        this.situacaoProduto = situacaoProduto;
    }

}
