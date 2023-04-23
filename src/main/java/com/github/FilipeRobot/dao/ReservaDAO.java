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

    public List<Reserva> buscarReservas(){
        String jpql = "SELECT r FROM Reserva r";
        try {
            return entityManager.createQuery(jpql, Reserva.class)
                    .getResultList();
        } catch (NoResultException exception) {
            throw new NoResultException("Nenhuma reserva encontrada");
        }
    }

    public void editarReserva(Reserva reserva){
        entityManager.merge(reserva);
    }

    public void deletarReserva(Reserva reserva) {
        reserva = entityManager.merge(reserva);
        entityManager.remove(reserva);
    }
}
