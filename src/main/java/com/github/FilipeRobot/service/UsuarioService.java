package com.github.FilipeRobot.service;

import com.github.FilipeRobot.dao.UsuarioDAO;
import com.github.FilipeRobot.model.Usuario;
import com.github.FilipeRobot.utils.JPAUtils;

import javax.persistence.EntityManager;

public class UsuarioService implements AutoCloseable {
    private final EntityManager entityManager;

    private final UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.entityManager = JPAUtils.getEntityManager();
        this.usuarioDAO = new UsuarioDAO(this.entityManager);
    }

    public void registrar(Usuario usuario) {
        if (usuario.getLogin().trim().isEmpty()) {
            throw new RuntimeException("Usuário não informado!");
        }
        if (usuario.getSenha().trim().isEmpty()) {
            throw new RuntimeException("Senha não informada!");
        }

        this.entityManager.getTransaction().begin();

        usuarioDAO.registrar(usuario);

        this.entityManager.getTransaction().commit();
    }

    public Usuario buscarPorID(Long id) {
        return usuarioDAO.buscarPorID(id);
    }

    public Usuario buscarPorLogin(String login) {
        return usuarioDAO.buscarPorLogin(login);
    }

    public void editar(Usuario usuario, String newLogin, String newSenha) {
        this.entityManager.getTransaction().begin();
        usuarioDAO.editarUsuario(usuario);
        usuario.setLogin(newLogin);
        usuario.setSenha(newSenha);
        this.entityManager.getTransaction().commit();
    }

    public void deletar(Usuario usuario) {
        this.entityManager.getTransaction().begin();
        usuarioDAO.deletarUsuario(usuario);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void close() {
        entityManager.close();
    }
}
