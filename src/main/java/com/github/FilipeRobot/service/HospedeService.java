package com.github.FilipeRobot.service;

import com.github.FilipeRobot.dao.HospedeDAO;
import com.github.FilipeRobot.model.Hospede;
import com.github.FilipeRobot.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class HospedeService implements AutoCloseable {
    private final EntityManager entityManager;

    private final HospedeDAO hospedeDAO;

    public HospedeService() {
        this.entityManager = JPAUtils.getEntityManager();
        this.hospedeDAO = new HospedeDAO(this.entityManager);
    }

    public HospedeService(EntityManager entityManager) {
        this.entityManager = entityManager;
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

        // TODO vincular e validar reserva ao hospede
//        if (hospede.getReservas() == null || hospede.getReservas().size() == 0) {
//            throw new RuntimeException("Reserva não informada");
//        }
        return true;
    }

    public Hospede buscarPorID(Long id) {
        return hospedeDAO.buscarPorID(id);
    }

    public List<Hospede> buscarPorSobrenome(String sobrenome) {
        if (sobrenome.length() < 3) {
            throw new RuntimeException("A busca deve conter pelo menos 3 caracteres");
        }

        if (!sobrenome.matches("[^\\p{M}\\p{S}\\p{P}\\p{C}]+")) {
            throw new RuntimeException("A busca não permite caracteres especiais, por favor tente novamente!");
        }

        return hospedeDAO.buscarPorSobrenome(sobrenome);
    }

    public List<Hospede> buscarTodos() {
        return hospedeDAO.buscarAll();
    }

    // TODO desenvolver editar e deletar hospede
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
