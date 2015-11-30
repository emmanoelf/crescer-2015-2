package br.com.cwi.crescer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Produto;

@Repository
public class ProdutoDAO {

    @PersistenceContext
    private EntityManager em;

    public Produto findById(Long id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> findAll() {
        return em.createQuery("FROM Produto", Produto.class).getResultList();
    }

    @Transactional
    public Produto save(Produto produto) {
        if (produto.getIdProduto() == null) {
            em.persist(produto);
            return produto;
        }
        return em.merge(produto);
    }

    public List<Produto> findByMaterialAndServico(Produto produto) {
        return em.createQuery("FROM Produto p where p.servico = :servico and p.material = :material", Produto.class)
                .setParameter("material", produto.getMaterial())
                .setParameter("servico", produto.getServico())
                .getResultList();
    }
}
