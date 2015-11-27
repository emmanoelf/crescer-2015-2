package br.com.cwi.crescer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cliente;

@Repository
public class ClienteDAO {

    @PersistenceContext
    private EntityManager em;

    public Cliente findById(Long id) {
        return em.find(Cliente.class, id);
    }

    public List<Cliente> listarResumoDTO() {
        return em.createQuery("FROM Cliente", Cliente.class)
                .getResultList();
    }

    @Transactional
    public Cliente save(Cliente cliente) {
        if (cliente.getIdCliente() == null) {
            em.persist(cliente);
            return cliente;
        }
        return em.merge(cliente);
    }

    @Transactional
    public void remove(Long id) {
        em.remove(em.getReference(Cliente.class, id));
    }
}
