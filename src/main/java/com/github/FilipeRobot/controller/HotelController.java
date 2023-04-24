package com.github.FilipeRobot.controller;

import com.github.FilipeRobot.model.Hospede;
import com.github.FilipeRobot.model.Reserva;
import com.github.FilipeRobot.model.Usuario;
import com.github.FilipeRobot.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class HotelController implements AutoCloseable {
    private final EntityManager entityManager;

    // TODO desenvolver mais usos para o loginController, como cadastro de usuário e mudar senha
    private LoginController loginController = null;
    private final ReservaController reservaController;
    private final HospedeController hospedeController;

    public HotelController() {
        this.entityManager = JPAUtils.getEntityManager();
        this.reservaController = new ReservaController(entityManager);
        this.hospedeController = new HospedeController(entityManager);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Executou close");
        entityManager.close();
    }

    public boolean login(String loginInformado, String senhaInformada) {
        Usuario usuario;

        this.loginController = new LoginController(entityManager);
        usuario = loginController.buscarUsuario(loginInformado, senhaInformada);

        return usuario != null;
    }

    public List<Reserva> buscarReservas() {
        return reservaController.buscarReservas();
    }

    public Reserva buscarReservaPorId(long idReserva) {
        return reservaController.buscarReserva(idReserva);
    }

    public List<Hospede> buscarHospedes() {
        return hospedeController.buscarTodos();
    }

    public List<Hospede> buscarHospedePorSobrenome(String sobrenome) {
        return hospedeController.buscarPorSobrenome(sobrenome);
    }

    public void deletarReserva(Long id) {
        reservaController.deletarReserva(id);
    }

    public void deletarHospede(Long id) {
        hospedeController.deletarHospede(id);
    }
}
