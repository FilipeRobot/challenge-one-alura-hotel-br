package com.github.FilipeRobot.dao;

import com.github.FilipeRobot.model.Reserva;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class ReservaDAO {
    private final EntityManager entityManager;

    public ReservaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void registrar(Reserva reserva) {
        entityManager.persist(reserva);
    }

    public Reserva buscarPorID(Long id){
        Reserva reserva = entityManager.find(Reserva.class, id);
        if (reserva == null) {
            throw new NoResultException("Reserva não encontrado");
        }
        return reserva;
    }

    public List<Reserva> buscarAll(){
        String jpql = "SELECT r FROM Reserva r";
        return entityManager.createQuery(jpql, Reserva.class).getResultList();
    }

//    public Reserva buscarPorLogin(String login) {
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

    public void editarUsuario(Reserva reserva){
        entityManager.merge(reserva);
    }

    public void deletarUsuario(Reserva reserva) {
        reserva = entityManager.merge(reserva);
        entityManager.remove(reserva);
    }
}
