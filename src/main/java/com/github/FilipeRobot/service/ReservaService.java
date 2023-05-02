package com.github.FilipeRobot.service;

import com.github.FilipeRobot.dao.ReservaDAO;
import com.github.FilipeRobot.model.DTO.DadosCompletosReserva;
import com.github.FilipeRobot.model.DTO.DadosReserva;
import com.github.FilipeRobot.model.Reserva;

import javax.persistence.EntityManager;
import java.util.Calendar;
import java.util.List;

public class ReservaService {
    private final EntityManager entityManager;

    private final ReservaDAO reservaDAO;

    public ReservaService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.reservaDAO = new ReservaDAO(this.entityManager);
    }

    public Long registrar(DadosReserva dados) {
        Reserva reserva = new Reserva(dados);

        this.entityManager.getTransaction().begin();

        reservaDAO.registrar(reserva);

        this.entityManager.getTransaction().commit();

        return reserva.getId();
    }

    public DadosCompletosReserva buscarPorID(Long id) {
        return new DadosCompletosReserva(reservaDAO.buscarPorID(id));
    }

    public List<DadosCompletosReserva> buscarReservas() {
        return reservaDAO.buscarReservas()
                .stream()
                .map(DadosCompletosReserva::new)
                .toList();
    }

    public void editarReserva(Long id, DadosReserva dados) {
        Reserva reserva = reservaDAO.buscarPorID(id);
        this.entityManager.getTransaction().begin();
        reserva.atualizarDados(dados);
        this.entityManager.getTransaction().commit();
    }

    public void deletarReserva(Long id) {
        Reserva reserva = reservaDAO.buscarPorID(id);
        this.entityManager.getTransaction().begin();
        reservaDAO.deletarReserva(reserva);
        this.entityManager.getTransaction().commit();
    }

    public int calcularValor(Calendar dataEntrada, Calendar dataSaida) {
        int valorDaReserva;
        int valorDiaria = 10;
        int dias = -1;
        while (dataEntrada.before(dataSaida) || dataEntrada.equals(dataSaida)) {
            dias++;
            dataEntrada.add(Calendar.DATE, 1);
        }

        if (dias == 0) {
            valorDaReserva = valorDiaria;
        } else {
            valorDaReserva = valorDiaria * dias;
        }

        return valorDaReserva;
    }
}
