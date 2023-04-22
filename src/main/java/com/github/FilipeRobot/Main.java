package com.github.FilipeRobot;

import com.github.FilipeRobot.model.Hospede;
import com.github.FilipeRobot.model.Usuario;
import com.github.FilipeRobot.service.HospedeService;
import com.github.FilipeRobot.service.UsuarioService;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
//        testarUsuario(true);
//
        testarHospedeReserva();
//        try (ReservaService service = new ReservaService()){
//            LocalDate data1 = LocalDate.parse("2023-04-10");
//            LocalDate data2 = LocalDate.parse("2023-04-11");
//            Reserva reserva = new Reserva(
//                    data1,
//                    data2,
//                    "dinheiro");
//
//            service.registrar(reserva);
//        }
    }

    private static void testarHospedeReserva() {
        Hospede hospede = new Hospede(
                "NomeTeste",
                "SobrenomeTeste",
                LocalDate.parse("2023-04-10"),
                "brasil",
                "0000-0000",
                1L
        );
        // Registrar a reserva no banco
        // buscar ID da reserva
        // registrar hospede com o ID da reserva preveamente registrada

//        LocalDate data1 = LocalDate.parse("2023-04-10");
//        LocalDate data2 = LocalDate.parse("2023-04-11");
//        Reserva reserva = new Reserva(
//                data1,
//                data2,
//                "dinheiro");
//
        try (HospedeService service = new HospedeService()){
            service.registrar(hospede);
        }
//
//        System.out.println("========================");

//        try (HospedeService service = new HospedeService()){
//            Hospede hospede1 = service.buscarPorID(2L);
//
//            System.out.println(hospede1.getNome());
//
//            System.out.println("===========");
//
//            hospede1.getReservas().forEach(reserva1 -> {
//                System.out.println(reserva1.getFormaPagamento());
//            });
//        }
    }

    private static void testarUsuario(boolean apenasCriar) {
        try (UsuarioService service = new UsuarioService()) {
            Usuario usuario = new Usuario("admin", "admin");
            service.registrar(usuario);
            System.out.println(usuario);
        }


        if (!apenasCriar) {
            try (UsuarioService service = new UsuarioService()) {
                Usuario buscar = service.buscarPorID(1L);

                System.out.println("teste buscar por id: " + buscar);

                service.editar(buscar, "testeEditar", "teste");

                System.out.println("====================");
            }

            try (UsuarioService service = new UsuarioService()) {
                Usuario buscar2 = service.buscarPorLogin("testeEditar");
                System.out.println("teste buscar por login: " + buscar2);
                service.deletar(buscar2);
                System.out.println("====================");
            }
        }
    }
}