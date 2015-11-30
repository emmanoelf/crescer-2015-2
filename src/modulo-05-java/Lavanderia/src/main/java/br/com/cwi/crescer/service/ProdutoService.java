package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.MaterialDAO;
import br.com.cwi.crescer.dao.ProdutoDAO;
import br.com.cwi.crescer.dao.ServicoDAO;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.dto.ProdutoDTOEditar;
import br.com.cwi.crescer.dto.ProdutoDTOIncluir;
import br.com.cwi.crescer.mapper.ProdutoMapper;

@Service
public class ProdutoService {

    private ProdutoDAO produtoDAO;
    private ServicoDAO servicoDAO;
    private MaterialDAO materialDAO;

    @Autowired
    public ProdutoService(ProdutoDAO produtoDAO, ServicoDAO servicoDAO, MaterialDAO materialDAO) {
        super();
        this.produtoDAO = produtoDAO;
        this.servicoDAO = servicoDAO;
        this.materialDAO = materialDAO;
    }

    public Long buscarPeloId(Long id) {
        return produtoDAO.findById(id).getIdProduto();
    }

    public ProdutoDTOIncluir buscarPorId(Long id) {
        Produto produto = produtoDAO.findById(id);
        return ProdutoMapper.toDTOIncluir(produto);
    }

    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtos = produtoDAO.findAll();
        List<ProdutoDTO> dtos = new ArrayList<ProdutoDTO>();
        for (Produto produto : produtos) {
            dtos.add(new ProdutoDTO(produto));
        }
        return dtos;
    }

    public void incluir(ProdutoDTOIncluir dto) {
        Produto entity = ProdutoMapper.getNewEntity(dto);
        entity.setMaterial(materialDAO.findById(dto.getMaterial()));
        entity.setServico(servicoDAO.findById(dto.getServico()));
        entity.setSituacaoProduto(SituacaoProduto.ATIVO);
        produtoDAO.save(entity);
    }

    public void atualizar(ProdutoDTOEditar dto) {
        ProdutoDTOIncluir entity = ProdutoMapper.toDTOIncluir(dto);
        Produto produto = produtoDAO.findById(entity.getIdProduto());
        ProdutoMapper.merge(entity, produto);
        produtoDAO.save(produto);
    }
}
