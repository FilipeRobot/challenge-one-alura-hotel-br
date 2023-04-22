package com.github.FilipeRobot.dao;

import com.github.FilipeRobot.model.Hospede;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class HospedeDAO {
    private final EntityManager entityManager;

    public HospedeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void registrar(Hospede hospede) {
        entityManager.persist(hospede);
    }

    public Hospede buscarPorID(Long id){
        Hospede hospede = entityManager.find(Hospede.class, id);
        if (hospede == null) {
            throw new NoResultException("Usuário não encontrado");
        }
        return hospede;
    }

    public List<Hospede> buscarAll() {
        String jpql = "SELECT h FROM Hospede h";

        return entityManager.createQuery(jpql, Hospede.class).getResultList();
    }

    public List<Hospede> buscarPorSobrenome(String sobrenome) {
        String jpql = "SELECT h FROM Hospede h WHERE h.sobrenome LIKE :sobrenome";

        try {
            return entityManager.createQuery(jpql, Hospede.class)
                    .setParameter("sobrenome", sobrenome)
                    .getResultList();
        } catch (NoResultException exception) {
            throw new NoResultException("Hospede não encontrado");
        }
    }
//
//    public void editarUsuario(Reserva reserva){
//        entityManager.merge(reserva);
//    }
//
//    public void deletarUsuario(Reserva reserva) {
//        reserva = entityManager.merge(reserva);
//        entityManager.remove(reserva);
//    }
}
