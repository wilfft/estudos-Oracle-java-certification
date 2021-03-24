package thread.gerenciadorDeTransacao;

public class TarefaAcessaBancoAoContrario implements Runnable {

    private GerenciadorDeTransacao tx;
    private PollDeConexao poll;

    public TarefaAcessaBancoAoContrario(PollDeConexao poll, GerenciadorDeTransacao tx) {
        this.tx = tx;
        this.poll = poll;
    }


    @Override
    public void run() {
        System.out.println("ACESSANDO POOLL DE CONEXOES por " + Thread.currentThread().getName());
        synchronized (poll) {
            System.out.println("CHAVE DE TX COM: " + Thread.currentThread().getName());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (tx) {
                System.out.println("CHAVE DE poll COM: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}

