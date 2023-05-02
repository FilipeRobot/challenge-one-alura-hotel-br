package com.github.FilipeRobot.model;

import com.github.FilipeRobot.model.DTO.DadosUsuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@ToString
public class Usuario {
    @Id
    private String login;
    private String senha;

    public Usuario(DadosUsuario dados) {
        this.login = dados.login();
        this.senha = dados.senha();
    }
}
