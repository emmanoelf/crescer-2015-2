package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.MaterialDAO;

@Service
public class MaterialService {

    private MaterialDAO materialDAO;

    @Autowired
    public MaterialService(MaterialDAO materialDAO) {
        super();
        this.materialDAO = materialDAO;
    }

    public String buscarPorDescricao(Long id) {
        String descricao = materialDAO.findById(id).getDescricao();
        return descricao.toUpperCase();
    }
}
