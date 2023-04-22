package com.github.FilipeRobot.controller;

import com.github.FilipeRobot.model.Reserva;
import com.github.FilipeRobot.service.ReservaService;

import java.util.List;

public class ReservaController implements AutoCloseable {
    private final ReservaService service;
    public ReservaController() {
        this.service = new ReservaService();
    }

    public void registrar(Reserva reserva) {
        this.service.registrar(reserva);
    }

    public Reserva buscarReserva(Long id) {
        return service.buscarPorID(id);
    }

    public List<Reserva> buscar() {
        return service.buscarTodas();
    }

    @Override
    public void close() {
        service.close();
    }
}
