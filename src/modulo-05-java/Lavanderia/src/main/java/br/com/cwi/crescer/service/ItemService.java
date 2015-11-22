package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ItemDAO;

@Service
public class ItemService {

    private ItemDAO itemDAO;

    @Autowired
    public ItemService(ItemDAO itemDAO) {
        super();
        this.itemDAO = itemDAO;
    }

    public Long buscarPorId(Long id) {
        return itemDAO.findById(id).getIdItem();
    }
}
