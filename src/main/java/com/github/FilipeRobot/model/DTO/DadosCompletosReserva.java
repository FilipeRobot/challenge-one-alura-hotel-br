package com.github.FilipeRobot.model.DTO;

import com.github.FilipeRobot.model.Reserva;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCompletosReserva(Long id, LocalDate dataEntrada, LocalDate dataSaida, BigDecimal valor,
                                    String formaPagamento) {
    public DadosCompletosReserva(Reserva reserva) {
        this(
                reserva.getId(),
                reserva.getDataEntrada(),
                reserva.getDataSaida(),
                reserva.getValor(),
                reserva.getFormaPagamento()
        );
    }
}
