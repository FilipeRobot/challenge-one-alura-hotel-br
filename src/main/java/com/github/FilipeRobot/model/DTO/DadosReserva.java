package com.github.FilipeRobot.model.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public record DadosReserva(LocalDate dataEntrada, LocalDate dataSaida, BigDecimal valor, String formaPagamento) {
    private static final List<String> formasDePagamento = List.of("Cartão de Crédito", "Cartão de Débito", "Dinheiro");
    public DadosReserva(Date dataEntrada, Date dataSaida, int valor, String formaPagamento) {
        this(
                dataEntrada.toInstant().atZone(ZoneId.of("-03:00")).toLocalDate(),
                dataSaida.toInstant().atZone(ZoneId.of("-03:00")).toLocalDate(),
                new BigDecimal(valor),
                formaPagamento
        );
    }

    public static void validar(Date dataEntrada, Date dataSaida, int valor, String formaPagamento){
        if (dataEntrada == null) {
            throw new RuntimeException("Data de entrada não informada!");
        }
        if (dataSaida == null) {
            throw new RuntimeException("Data de saida não informada!");
        }
        if (valor < 10) {
            throw new RuntimeException("Valor da reserva informado está incorreto ou não é valido!");
        }
        if (formaPagamento.isBlank() || !formasDePagamento.contains(formaPagamento)) {
            throw new RuntimeException("Forma de pagamento não informada ou é invalida!");
        }
    }
}
