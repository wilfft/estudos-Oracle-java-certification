package thread.gerenciadorDeTransacao;

public class TarefaAcessaBanco implements Runnable {
    private PollDeConexao poll;
    private GerenciadorDeTransacao tx;

    public TarefaAcessaBanco(PollDeConexao poll, GerenciadorDeTransacao tx) {
        this.poll = poll;
        this.tx = tx;
    }

    @Override
    public void run() {
        System.out.println("ACESSANDO POOLL DE CONEXOES por " + Thread.currentThread().getName());
        synchronized (poll) {
            System.out.println("CHAVE DE POLL COM: " + Thread.currentThread().getName());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (tx) {
                System.out.println("CHAVE DE TX COM: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }


    }
}
