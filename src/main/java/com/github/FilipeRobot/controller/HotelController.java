package com.github.FilipeRobot.controller;

import com.github.FilipeRobot.model.DTO.*;
import com.github.FilipeRobot.service.HospedeService;
import com.github.FilipeRobot.service.ReservaService;
import com.github.FilipeRobot.service.UsuarioService;
import com.github.FilipeRobot.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.util.Calendar;
import java.util.List;

public class HotelController {
    private final UsuarioService usuarioService;
    private final ReservaService reservaService;
    private final HospedeService hospedeService;

    public HotelController() {
        EntityManager entityManager;
        try {
            entityManager = JPAUtils.getEntityManager();
        } catch (LinkageError exception) {
            throw new RuntimeException("Não foi possível se conectar ao banco de dados", exception);
        }
        this.usuarioService = new UsuarioService(entityManager);
        this.reservaService = new ReservaService(entityManager);
        this.hospedeService = new HospedeService(entityManager);
    }

    public void login(DadosUsuario usuario) {
        usuarioService.login(usuario);
    }

    public void cadastrar(DadosUsuario dados, String senhaConfirmacao) {
        usuarioService.registrar(dados, senhaConfirmacao);
    }

    public Long registrarReserva(DadosReserva dadosReserva) {
        return reservaService.registrar(dadosReserva);
    }

    public int calcularValorReserva(Calendar dataEntrada, Calendar dataSaida) {
        return reservaService.calcularValor(dataEntrada, dataSaida);
    }

    public List<DadosCompletosReserva> buscarReservas() {
        return reservaService.buscarReservas();
    }

    public DadosCompletosReserva buscarReservaPorId(long idReserva) {
        return reservaService.buscarPorID(idReserva);
    }

    public void editarReserva(String id, DadosReserva dadosReserva) {
        reservaService.editarReserva(Long.valueOf(id), dadosReserva);
    }

    public void deletarReserva(Long id) {
        reservaService.deletarReserva(id);
    }

    public void registrarHospede(DadosHospede dadosHospede) {
        hospedeService.registrar(dadosHospede);
    }

    public List<DadosCompletosHospede> buscarHospedes() {
        return hospedeService.buscarTodos();
    }

    public List<DadosCompletosHospede> buscarHospedePorSobrenome(String sobrenome) {
        return hospedeService.buscarPorSobrenome(sobrenome);
    }

    public void editarHospede(String id, DadosHospede dados) {
        hospedeService.editarHospede(Long.valueOf(id), dados);
    }

    public void deletarHospede(Long id) {
        hospedeService.deletarHospede(id);
    }
}
