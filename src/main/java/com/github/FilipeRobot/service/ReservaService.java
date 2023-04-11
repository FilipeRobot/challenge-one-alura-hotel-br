package com.github.FilipeRobot.service;

import com.github.FilipeRobot.dao.ReservaDAO;
import com.github.FilipeRobot.dao.UsuarioDAO;
import com.github.FilipeRobot.model.Reserva;
import com.github.FilipeRobot.model.Usuario;
import com.github.FilipeRobot.utils.JPAUtils;

import javax.persistence.EntityManager;

public class ReservaService implements AutoCloseable {
    private final EntityManager entityManager;

    private final ReservaDAO reservaDAO;

    public ReservaService() {
        this.entityManager = JPAUtils.getEntityManager();
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
//
//    public Usuario buscarPorLogin(String login) {
//        return reservaDAO.buscarPorLogin(login);
//    }
//
//    public void editar(Usuario usuario, String newLogin, String newSenha) {
//        this.entityManager.getTransaction().begin();
//        reservaDAO.editarUsuario(usuario);
//        usuario.setLogin(newLogin);
//        usuario.setSenha(newSenha);
//        this.entityManager.getTransaction().commit();
//    }
//
//    public void deletar(Usuario usuario) {
//        this.entityManager.getTransaction().begin();
//        reservaDAO.deletarUsuario(usuario);
//        this.entityManager.getTransaction().commit();
//    }

    @Override
    public void close() {
        entityManager.close();
    }
}
