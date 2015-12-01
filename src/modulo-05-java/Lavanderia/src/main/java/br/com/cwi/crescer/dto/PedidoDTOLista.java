package br.com.cwi.crescer.dto;

import java.math.BigDecimal;
import java.util.Date;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

public class PedidoDTOLista {

    private Long idPedido;
    private Cliente cliente;
    private SituacaoPedido situacao;
    private Date dataInclusao;
    private BigDecimal valor;

    public PedidoDTOLista(Pedido pedido) {
        this.idPedido = pedido.getIdPedido();
        this.cliente = pedido.getCliente();
        this.dataInclusao = pedido.getDataInclusao();
        this.situacao = pedido.getSituacao();
        this.valor = pedido.getValorPedido();
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public SituacaoPedido getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoPedido situacao) {
        this.situacao = situacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
