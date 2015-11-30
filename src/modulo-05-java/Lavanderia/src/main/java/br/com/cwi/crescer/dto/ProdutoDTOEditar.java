package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotBlank;

import br.com.cwi.crescer.domain.Produto.SituacaoProduto;

public class ProdutoDTOEditar {

    private Long idProduto;

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
