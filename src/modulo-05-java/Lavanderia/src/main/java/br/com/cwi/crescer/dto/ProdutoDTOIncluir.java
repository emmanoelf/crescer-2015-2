package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotBlank;

import br.com.cwi.crescer.domain.Produto.SituacaoProduto;

public class ProdutoDTOIncluir {

    private Long idProduto;

    @NotBlank
    private Long servico;

    @NotBlank
    private Long material;

    @NotBlank
    private BigDecimal valor;

    @NotBlank
    private Long prazo;

    private SituacaoProduto situacao;

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getServico() {
        return servico;
    }

    public void setServico(Long servico) {
        this.servico = servico;
    }

    public Long getMaterial() {
        return material;
    }

    public void setMaterial(Long material) {
        this.material = material;
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
        return situacao;
    }

    public void setSituacao(SituacaoProduto situacao) {
        this.situacao = situacao;
    }

}