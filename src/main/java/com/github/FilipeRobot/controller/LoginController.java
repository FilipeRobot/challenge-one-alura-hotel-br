package com.github.FilipeRobot.controller;

import com.github.FilipeRobot.model.Usuario;
import com.github.FilipeRobot.service.UsuarioService;

public class LoginController implements AutoCloseable {
    private final UsuarioService service;
    public LoginController() {
        this.service = new UsuarioService();
    }

    public Usuario buscarUsuario(String loginInformado, String senhaInformada) {
        Usuario usuario = service.buscarPorLogin(loginInformado);
        if (!usuario.getSenha().equals(senhaInformada)){
            throw new RuntimeException("Senha informada é invalida");
        }
        return usuario;
    }

    @Override
    public void close() {
        service.close();
    }
}
