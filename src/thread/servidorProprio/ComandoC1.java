package thread.servidorProprio;

import java.io.PrintStream;

 class ComandoC1 implements Runnable {
    private PrintStream saida;

    public ComandoC1(PrintStream saida) {
        this.saida = saida;
    }

    @Override
    public void run() {
        System.out.println("Executando comando c1... aguarde 10segundos");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        saida.println("COMANDO C1 Executado");
    }
}
