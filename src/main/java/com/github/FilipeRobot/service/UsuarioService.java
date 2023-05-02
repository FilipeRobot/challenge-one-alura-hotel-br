package com.github.FilipeRobot.service;

import com.github.FilipeRobot.dao.UsuarioDAO;
import com.github.FilipeRobot.model.DTO.DadosUsuario;
import com.github.FilipeRobot.model.Usuario;

import javax.persistence.EntityManager;

public class UsuarioService {
    private final EntityManager entityManager;

    private final UsuarioDAO usuarioDAO;

    public UsuarioService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.usuarioDAO = new UsuarioDAO(this.entityManager);
    }

    public void registrar(DadosUsuario dados, String senhaConfirmacao) {
        if (dados.login().equals("Digite seu nome de usuário") || dados.login().isBlank()) {
            throw new RuntimeException("Nome de usuário não informado.");
        }

        if (dados.senha().equals("********") || dados.senha().isBlank()) {
            throw new RuntimeException("Senha não informada.");
        }

        if (senhaConfirmacao.equals("********") || senhaConfirmacao.isBlank()) {
            throw new RuntimeException("Senha de confirmação não informada.");
        }

        if (!dados.senha().equals(senhaConfirmacao)) {
            throw new RuntimeException("Senha de confirmação é diferente da senha informada, verifique as informações novamente.");
        }

        if (usuarioDAO.usuarioExiste(dados.login())) {
            throw new RuntimeException("Usuário já existe!");
        }

        this.entityManager.getTransaction().begin();

        usuarioDAO.registrar(new Usuario(dados));

        this.entityManager.getTransaction().commit();
    }

    public void login(DadosUsuario dados) {
        if (dados.login().equals("Digite seu nome de usuário") || dados.login().isBlank()) {
            throw new RuntimeException("Nome de usuário não informado");
        }

        if (dados.senha().equals("********") || dados.senha().isBlank()) {
            throw new RuntimeException("Senha não informada");
        }

        DadosUsuario usuario = new DadosUsuario(usuarioDAO.buscarPorLogin(dados.login()));

        if (!dados.senha().equals(usuario.senha())) {
            throw new RuntimeException("Senha informada é invalida");
        }
    }
}
