package com.github.FilipeRobot.model.DTO;

import com.github.FilipeRobot.model.Hospede;

import java.time.LocalDate;

public record DadosCompletosHospede(Long id, String nome, String sobrenome, LocalDate dataNascimento, String nacionalidade, String telefone, Long reserva) {
    public DadosCompletosHospede(Hospede hospede) {
        this(
                hospede.getId(),
                hospede.getNome(),
                hospede.getSobrenome(),
                hospede.getDataNascimento(),
                hospede.getNacionalidade(),
                hospede.getTelefone(),
                hospede.getReserva()
        );
    }
}
