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

        try {
            return entityManager.createQuery(jpql, Hospede.class)
                    .getResultList();
        } catch (NoResultException exception) {
            throw new NoResultException("Nenhum hospede encontrado");
        }
    }

    public List<Hospede> buscarPorSobrenome(String sobrenome) {
        String jpql = "SELECT h FROM Hospede h WHERE h.sobrenome LIKE :sobrenome";

        List<Hospede> resultList = entityManager.createQuery(jpql, Hospede.class)
                .setParameter("sobrenome", sobrenome + "%")
                .getResultList();

        if (resultList.size() < 1) {
            throw new NoResultException("Hospede não encontrado");
        } else {
            return resultList;
        }
    }

    public void editarHospede(Hospede hospede){
        entityManager.merge(hospede);
    }

    public void deletarHospede(Hospede hospede) {
        hospede = entityManager.merge(hospede);
        entityManager.remove(hospede);
    }
}
