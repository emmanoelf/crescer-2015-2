package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ServicoDAO;

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
}
