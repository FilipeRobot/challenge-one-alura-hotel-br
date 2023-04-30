package com.github.FilipeRobot.model;

import com.github.FilipeRobot.model.DTO.DadosReserva;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "reservas")
@NoArgsConstructor
@Getter
@ToString
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_entrada")
    private LocalDate dataEntrada;
    @Column(name = "data_saida")
    private LocalDate dataSaida;
    private BigDecimal valor;
    @Column(name = "forma_pagamento")
    private String formaPagamento;

    public Reserva(DadosReserva dados) {
        this.dataEntrada = dados.dataEntrada();
        this.dataSaida = dados.dataSaida();
        this.valor = dados.valor();
        this.formaPagamento = dados.formaPagamento();
    }

    public void atualizarDados(DadosReserva dados) {
        this.dataEntrada = dados.dataEntrada();
        this.dataSaida = dados.dataSaida();
        this.valor = dados.valor();
        this.formaPagamento = dados.formaPagamento();
    }
}
