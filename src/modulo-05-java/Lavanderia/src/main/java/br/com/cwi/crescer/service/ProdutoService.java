package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ProdutoDAO;

@Service
public class ProdutoService {

    private ProdutoDAO produtoDAO;

    @Autowired
    public ProdutoService(ProdutoDAO produtoDAO) {
        super();
        this.produtoDAO = produtoDAO;
    }

    public Long buscarPeloId(Long id) {
        return produtoDAO.findById(id).getIdProduto();
    }

}
