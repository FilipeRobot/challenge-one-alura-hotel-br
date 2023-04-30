package com.github.FilipeRobot.controller;

import com.github.FilipeRobot.model.DTO.DadosCompletosHospede;
import com.github.FilipeRobot.model.DTO.DadosCompletosReserva;
import com.github.FilipeRobot.model.DTO.DadosHospede;
import com.github.FilipeRobot.model.DTO.DadosReserva;
import com.github.FilipeRobot.model.Usuario;
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
        EntityManager entityManager = JPAUtils.getEntityManager();
        this.usuarioService = new UsuarioService(entityManager);
        this.reservaService = new ReservaService(entityManager);
        this.hospedeService = new HospedeService(entityManager);
    }

    public void login(String loginInformado, String senhaInformada) {
        Usuario usuario = usuarioService.buscarPorLogin(loginInformado);

        if (!usuario.getSenha().equals(senhaInformada)){
            throw new RuntimeException("Senha informada é invalida");
        }
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
