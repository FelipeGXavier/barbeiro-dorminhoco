package org.example;

import java.util.concurrent.atomic.AtomicBoolean;

public class Barbeiro {

    private final AtomicBoolean dormindo = new AtomicBoolean(false);

    synchronized public void cortarCabelo(Cliente cliente) throws InterruptedException {
        if (this.dormindo.get()) {
            this.dormindo.set(false);
        }
        System.out.println("Cortando cabelo " + cliente.getNome());
        Thread.sleep(1000);
        System.out.println("Finalizando corte " + cliente.getNome());
    }

    public void dormir() throws InterruptedException {
        System.out.println("Nenhum cliente, barbeiro dormiu");
        this.dormindo.set(true);
    }

    public void acordar() {
        this.dormindo.set(false);
        System.out.println("Barbeiro acordou");
    }

    public AtomicBoolean getDormindo() {
        return dormindo;
    }
}
