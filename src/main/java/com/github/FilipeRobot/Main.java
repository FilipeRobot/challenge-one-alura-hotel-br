package com.github.FilipeRobot;

import com.github.FilipeRobot.model.Usuario;
import com.github.FilipeRobot.service.UsuarioService;


public class Main {
    public static void main(String[] args) {
        System.out.println("====================");
        try (UsuarioService service = new UsuarioService()) {
            Usuario usuario = new Usuario("admin", "admin");
            service.registrar(usuario);
            System.out.println(usuario);
            System.out.println("====================");

        }

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