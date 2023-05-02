package com.github.FilipeRobot.model.DTO;

import com.github.FilipeRobot.model.Usuario;

public record DadosUsuario(String login, String senha) {
    public DadosUsuario(Usuario usuario) {
        this(usuario.getLogin(), usuario.getSenha());
    }
}
