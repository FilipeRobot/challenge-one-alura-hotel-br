package com.github.FilipeRobot.model;

import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "reservas")
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

    public Reserva() {
    }

    public Reserva(LocalDate dataEntrada, LocalDate dataSaida, BigDecimal valor, String formaPagamento) {
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public Reserva(LocalDate dataEntrada, LocalDate dataSaida, String formaPagamento) {
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.formaPagamento = formaPagamento;
        this.valor = calcularValor(dataEntrada, dataSaida);
    }

    private BigDecimal calcularValor(LocalDate dataEntrada, LocalDate dataSaida) {
        BigDecimal valorDaReserva = new BigDecimal(BigInteger.ZERO);
        BigDecimal valorDiaria = new BigDecimal("10");

        int numeroDeDias = Period.between(dataEntrada, dataSaida).getDays();

        if (numeroDeDias == 0) {
            valorDaReserva = valorDaReserva.add(valorDiaria);
        } else {
            for (long i = 0; i <= numeroDeDias; i++) {
                valorDaReserva = valorDaReserva.add(valorDiaria);
            }
        }
        return valorDaReserva;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Long getId() {
        return id;
    }
}
