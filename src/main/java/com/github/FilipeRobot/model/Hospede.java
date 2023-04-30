package com.github.FilipeRobot.model;

import com.github.FilipeRobot.model.DTO.DadosHospede;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hospedes")
@NoArgsConstructor
@Getter
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

    public Hospede(DadosHospede dados) {
        this.nome = dados.nome();
        this.sobrenome = dados.sobrenome();
        this.dataNascimento = dados.dataNascimento();
        this.nacionalidade = dados.nacionalidade();
        this.telefone = dados.telefone();
        this.reserva = dados.reserva();
    }

    public void atualizarDados(DadosHospede dados) {
        this.nome = dados.nome();
        this.sobrenome = dados.sobrenome();
        this.dataNascimento = dados.dataNascimento();
        this.nacionalidade = dados.nacionalidade();
        this.telefone = dados.telefone();
        this.reserva = dados.reserva();
    }
}
