package com.github.FilipeRobot.controller;

import com.github.FilipeRobot.model.Hospede;
import com.github.FilipeRobot.service.HospedeService;

public class HospedeController implements AutoCloseable {
    private final HospedeService service;
    public HospedeController() {
        this.service = new HospedeService();
    }

    public void registrar(Hospede hospede) {
        this.service.registrar(hospede);
    }

    @Override
    public void close() {
        service.close();
    }
}
