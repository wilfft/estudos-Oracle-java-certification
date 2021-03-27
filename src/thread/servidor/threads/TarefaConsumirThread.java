package thread.servidor.threads;

import java.util.concurrent.BlockingQueue;

public class TarefaConsumirThread implements Runnable {
    private BlockingQueue<String> filaComandos;

    public TarefaConsumirThread(BlockingQueue<String> filaComandos) {
        this.filaComandos = filaComandos;
    }

    @Override
    public void run() {
        String comando = null;


        try {
            while ((comando = filaComandos.take()) != null) {
                System.out.println("Consumindo comando " + comando + ", " + Thread.currentThread().getName());
                Thread.sleep(10000);
                System.out.println("comando c3 consumido");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }


    }


}