package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.dto.PedidoDTO;

public class PedidoMapper {

    public static Pedido getNewEntity(PedidoDTO dto){
        Pedido entity = new Pedido();
        entity.setIdPedido(dto.getIdPedido());
        entity.setCliente(dto.getCliente());
        entity.setDataInclusao(dto.getDataInclusao());
        entity.setDataEntrega(dto.getDataEntrega());
        entity.setValorPedido(dto.getValorBruto());
        entity.setValorDesconto(dto.getValorDesconto());
        entity.setValorFinal(dto.getValorTotal());
        return entity;
    }

}
