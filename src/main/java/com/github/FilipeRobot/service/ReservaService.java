package com.github.FilipeRobot.service;

import com.github.FilipeRobot.dao.ReservaDAO;
import com.github.FilipeRobot.model.Reserva;
import com.github.FilipeRobot.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class ReservaService implements AutoCloseable {
    private final EntityManager entityManager;

    private final ReservaDAO reservaDAO;

    public ReservaService() {
        this.entityManager = JPAUtils.getEntityManager();
        this.reservaDAO = new ReservaDAO(this.entityManager);
    }

    public ReservaService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.reservaDAO = new ReservaDAO(this.entityManager);
    }

    public void registrar(Reserva reserva) {
//        if (reserva.getDataEntrada() == null) {
//            throw new RuntimeException("Data de entrada não informada!");
//        }
//        if (reserva.getDataSaida() == null) {
//            throw new RuntimeException("Data de saida não informada!");
//        }

        this.entityManager.getTransaction().begin();

        reservaDAO.registrar(reserva);

        this.entityManager.getTransaction().commit();
    }

    public Reserva buscarPorID(Long id) {
        return reservaDAO.buscarPorID(id);
    }

    public List<Reserva> buscarReservas() {
        return reservaDAO.buscarReservas();
    }

    public void deletarReserva(Reserva reserva) {
        this.entityManager.getTransaction().begin();
        reservaDAO.deletarReserva(reserva);
        this.entityManager.getTransaction().commit();
    }

    // TODO desenvolver editar reserva

    @Override
    public void close() {
        entityManager.close();
    }
}
