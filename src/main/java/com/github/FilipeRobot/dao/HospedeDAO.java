package com.github.FilipeRobot.dao;

import com.github.FilipeRobot.model.Hospede;
import com.github.FilipeRobot.model.Reserva;
import com.github.FilipeRobot.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

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
//
//    public Reserva buscarPorNome(String login) {
//        String jpql = "SELECT u FROM Reserva u WHERE u.login LIKE :login";
//
//        try {
//            return entityManager.createQuery(jpql, Reserva.class)
//                    .setParameter("login", login)
//                    .getSingleResult();
//        } catch (NoResultException exception) {
//            throw new NoResultException("Usuário não encontrado");
//        }
//    }
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
