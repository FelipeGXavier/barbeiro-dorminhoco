package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Barbeiro barbeiro = new Barbeiro();
        var barbearia = new Barbearia(barbeiro);
        barbearia.start();
        var clientes = List.of("João", "Felipe", "Lucas", "Maria", "Pedro", "Ana", "Flavia", "Virgulino");
        for (var nome : clientes) {
            new Cliente(nome, barbearia).start();
        }
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String nome = scanner.next();
            if (nome.isEmpty()) {
                break;
            }
            var cliente = new Cliente(nome, barbearia);
            cliente.start();
        }
    }
}