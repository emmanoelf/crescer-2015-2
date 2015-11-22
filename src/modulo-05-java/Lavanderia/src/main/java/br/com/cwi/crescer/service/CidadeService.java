package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.CidadeDAO;

@Service
public class CidadeService {

    private CidadeDAO cidadeDAO;

    @Autowired
    public CidadeService(CidadeDAO cidadeDao) {
        super();
        this.cidadeDAO = cidadeDao;
    }

    public String buscarPorNome(Long id) {
        String nome = cidadeDAO.findById(id).getNome();
        return nome.toUpperCase();
    }
}
