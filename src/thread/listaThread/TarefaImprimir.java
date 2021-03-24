package thread.listaThread;

public class TarefaImprimir implements Runnable {
    private Lista lista;

    public TarefaImprimir(Lista lista) {
        this.lista = lista;
    }
    @Override
    public void run() {


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        synchronized (lista) {
            if (!lista.estaCheia()) {
                try {
                    System.out.println("AGUARDANDO NOTIFICAÇAO DE LISTA CHEIA");
                    lista.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            for (int i = 0; i < lista.tamanho(); i++) {
                System.out.println(i + "  - " + lista.pegaElementos(i));
            }
        }
    }
}
