package com.github.FilipeRobot.service;

import com.github.FilipeRobot.dao.HospedeDAO;
import com.github.FilipeRobot.model.Hospede;
import com.github.FilipeRobot.utils.JPAUtils;

import javax.persistence.EntityManager;

public class HospedeService implements AutoCloseable {
    private final EntityManager entityManager;

    private final HospedeDAO hospedeDAO;

    public HospedeService() {
        this.entityManager = JPAUtils.getEntityManager();
        this.hospedeDAO = new HospedeDAO(this.entityManager);
    }

    public void registrar(Hospede hospede) {
        if (validar(hospede)) {
            this.entityManager.getTransaction().begin();

            hospedeDAO.registrar(hospede);

            this.entityManager.getTransaction().commit();
        }
    }

    private boolean validar(Hospede hospede) {
        if (hospede.getNome().trim().isEmpty()) {
            throw new RuntimeException("Nome não informado");
        }
//        if (hospede.getReservas() == null || hospede.getReservas().size() == 0) {
//            throw new RuntimeException("Reserva não informada");
//        }
        return true;
    }

    public Hospede buscarPorID(Long id) {
        return hospedeDAO.buscarPorID(id);
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
