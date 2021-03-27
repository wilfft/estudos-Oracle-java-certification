package thread.servidor.threads;

import java.io.PrintStream;

public class ComandoC1 implements Runnable {

    private PrintStream saida;

    public ComandoC1(PrintStream saidaCliente) {
        this.saida = saidaCliente;
    }

    @Override
    public void run() {
        saida.println("Execuntando comando c1. Aguarde...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        saida.println("Comando c1 executado");
        System.out.println("SERVER: Enviado comando c1 ao cliente");
    }
}
