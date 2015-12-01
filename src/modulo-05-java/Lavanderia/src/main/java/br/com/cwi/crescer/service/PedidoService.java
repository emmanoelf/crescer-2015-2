package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ClienteDAO;
import br.com.cwi.crescer.dao.PedidoDAO;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.dto.PedidoDTOLista;

@Service
public class PedidoService {

    private PedidoDAO pedidoDAO;
    private ClienteDAO clienteDAO;

    @Autowired
    public PedidoService(PedidoDAO pedidoDAO, ClienteDAO clienteDAO) {
        super();
        this.pedidoDAO = pedidoDAO;
        this.clienteDAO = clienteDAO;
    }

    public Long buscarPorId(Long id) {
        return pedidoDAO.findById(id).getIdPedido();
    }

    public List<PedidoDTOLista> listarPedidosListaDTO() {
        List<Pedido> pedidos = pedidoDAO.findAll();
        List<PedidoDTOLista> dtos = new ArrayList<PedidoDTOLista>();
        for (Pedido pedido : pedidos) {
            dtos.add(new PedidoDTOLista(pedido));
        }
        return dtos;
    }

    }
