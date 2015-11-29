package br.com.cwi.crescer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ServicoDAO;
import br.com.cwi.crescer.domain.Servico;

@Service
public class ServicoService {

    private ServicoDAO servicoDAO;

    @Autowired
    public ServicoService(ServicoDAO servicoDAO) {
        super();
        this.servicoDAO = servicoDAO;
    }

    public String buscarPorDescricao(Long id) {
        String descricao = servicoDAO.findById(id).getDescricao();
        return descricao.toUpperCase();
    }

    public List<Servico> listar() {
        return servicoDAO.findAll();
    }
}
