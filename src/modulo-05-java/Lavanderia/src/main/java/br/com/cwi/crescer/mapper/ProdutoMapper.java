package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.dto.ProdutoDTOEditar;
import br.com.cwi.crescer.dto.ProdutoDTOIncluir;

public class ProdutoMapper {

    public static Produto getNewEntity(ProdutoDTOIncluir produto) {
        Produto entity = new Produto();
        entity.setPrazo(produto.getPrazo());
        entity.setValorProduto(produto.getValor());
        entity.setSituacaoProduto(produto.getSituacao());
        return entity;
    }

    public static ProdutoDTO toDTO(Produto entity) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setIdProduto(entity.getIdProduto());
        dto.setIdServico(entity.getServico());
        dto.setIdMaterial(entity.getMaterial());
        dto.setPrazo(entity.getPrazo());
        dto.setValor(entity.getValorProduto());
        dto.setSituacaoProduto(entity.getSituacaoProduto());
        return dto;
    }

    public static ProdutoDTOIncluir toDTOIncluir(Produto entity) {
        ProdutoDTOIncluir dto = new ProdutoDTOIncluir();
        dto.setIdProduto(entity.getIdProduto());
        dto.setServico(entity.getServico().getIdServico());
        dto.setMaterial(entity.getMaterial().getIdMaterial());
        dto.setPrazo(entity.getPrazo());
        dto.setValor(entity.getValorProduto());
        dto.setSituacao(entity.getSituacaoProduto());
        return dto;
    }

    public static Produto merge(ProdutoDTOIncluir dto, Produto entity) {
        entity.setPrazo(dto.getPrazo());
        entity.setValorProduto(dto.getValor());
        entity.setSituacaoProduto(dto.getSituacao());
        return entity;
    }

    public static ProdutoDTOIncluir toDTOIncluir(ProdutoDTOEditar entity) {
        ProdutoDTOIncluir dto = new ProdutoDTOIncluir();
        dto.setIdProduto(entity.getIdProduto());
        dto.setPrazo(entity.getPrazo());
        dto.setValor(entity.getValor());
        dto.setSituacao(entity.getSituacao());
        return dto;
    }

}
