package thread.servidor.threads;

import thread.servidor.ComandoClass;

import java.util.concurrent.BlockingQueue;

public class TarefaProcessandoHTTP implements Runnable {

    BlockingQueue<ComandoClass> listaCompandos;

    public TarefaProcessandoHTTP(BlockingQueue<ComandoClass> listaCompandos) {
        this.listaCompandos = listaCompandos;
    }

    ComandoClass comando;

    @Override
    public void run() {

        try {
            while ((comando = listaCompandos.take()) != null) ;
            {
                Thread.sleep(10000);
                System.out.println(comando.getNome() + "  " + comando.getParams() + "  " + comando.getPrioridade());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
