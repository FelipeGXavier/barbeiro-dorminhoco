package org.example;

public class Cliente extends Thread {

    private final String nome;
    private final Barbearia barbearia;

    public Cliente(String nome, Barbearia barbearia) {
        this.nome = nome;
        this.barbearia = barbearia;
    }

    @Override
    public void run() {
        this.barbearia.novoCliente(this);
    }

    public String getNome() {
        return nome;
    }
}
