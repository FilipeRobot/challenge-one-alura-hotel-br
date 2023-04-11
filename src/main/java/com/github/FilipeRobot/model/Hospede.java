package com.github.FilipeRobot.model;

import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hospedes")
@ToString
public class Hospede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    private String nacionalidade;
    private String telefone;
    @Column(name = "id_reserva")
    private Long reserva;

    public Hospede() {
    }

    public Hospede(String nome, String sobrenome, LocalDate dataNascimento, String nacionalidade, String telefone, Long reserva) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.telefone = telefone;
        this.reserva = reserva;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getTelefone() {
        return telefone;
    }
}
