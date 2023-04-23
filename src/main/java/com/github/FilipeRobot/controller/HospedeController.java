package com.github.FilipeRobot.controller;

import com.github.FilipeRobot.model.Hospede;
import com.github.FilipeRobot.service.HospedeService;

import javax.persistence.EntityManager;
import java.util.List;

public class HospedeController implements AutoCloseable {
    private final HospedeService service;
    public HospedeController() {
        this.service = new HospedeService();
    }

    public HospedeController(EntityManager entityManager) {
        this.service = new HospedeService(entityManager);
    }

    public void registrar(Hospede hospede) {
        this.service.registrar(hospede);
    }

    public List<Hospede> buscarPorSobrenome(String sobrenome) {
        return service.buscarPorSobrenome(sobrenome);
    }

    public List<Hospede> buscarTodos() {
        return service.buscarTodos();
    }

    @Override
    public void close() {
        service.close();
    }
}
