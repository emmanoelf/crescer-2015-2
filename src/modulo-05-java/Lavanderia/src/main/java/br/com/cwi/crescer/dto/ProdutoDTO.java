package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.domain.Servico;

public class ProdutoDTO {

    private Long idProduto;
    private Servico idServico;
    private Material idMaterial;
    private BigDecimal valor;
    private Long prazo;
    private SituacaoProduto situacaoProduto;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto entity) {
        this.idProduto = entity.getIdProduto();
        this.idServico = entity.getServico();
        this.idMaterial = entity.getMaterial();
        this.valor = entity.getValorProduto();
        this.prazo = entity.getPrazo();
        this.situacaoProduto = entity.getSituacaoProduto();
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Servico getIdServico() {
        return idServico;
    }

    public void setIdServico(Servico idServico) {
        this.idServico = idServico;
    }

    public Material getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Material idMaterial) {
        this.idMaterial = idMaterial;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getPrazo() {
        return prazo;
    }

    public void setPrazo(Long prazo) {
        this.prazo = prazo;
    }

    public SituacaoProduto getSituacao() {
        return situacaoProduto;
    }

    public void setSituacaoProduto(SituacaoProduto situacaoProduto) {
        this.situacaoProduto = situacaoProduto;
    }

}
