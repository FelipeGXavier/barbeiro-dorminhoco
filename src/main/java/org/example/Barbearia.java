package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Barbearia extends Thread {

    BlockingQueue<Cliente> clientes = new LinkedBlockingQueue<>();
    private final Barbeiro barbeiro;
    public Barbearia(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (this.clientes.size() == 0 && !this.barbeiro.getDormindo().getAcquire()) {
                    this.barbeiro.dormir();
                } else if (this.clientes.size() > 0) {
                    if (this.barbeiro.getDormindo().getAcquire()) {
                        this.barbeiro.acordar();
                    }
                    this.barbeiro.cortarCabelo(this.clientes.take());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    synchronized public void novoCliente(Cliente cliente) {
        if (this.clientes.size() >= 5) {
            System.out.println("Fila está cheia, cliente " + cliente.getNome() + " deixou a barbearia");
            return;
        }
        this.clientes.add(cliente);
    }
}
