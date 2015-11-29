package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.dto.ProdutoDTO;

public class ProdutoMapper {

    public static Produto getNewEntity(Produto dto) {
        Produto entity = new Produto();
        entity.setPrazo(dto.getPrazo());
        entity.setValorProduto(dto.getValorProduto());
        entity.setSituacaoProduto(dto.getSituacaoProduto());
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

    public static Produto merge(ProdutoDTO dto, Produto entity) {
        entity.setPrazo(dto.getPrazo());
        entity.setValorProduto(dto.getValor());
        entity.setSituacaoProduto(dto.getSituacao());
        return entity;
    }
}
