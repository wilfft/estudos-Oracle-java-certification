package thread.gerenciadorDeTransacao;

public class MainBanco {
    public static void main(String[] args) {
        GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
        PollDeConexao poll = new PollDeConexao();


        new Thread(new TarefaAcessaBanco(poll, tx), "Thread1").
                start();
        new Thread(new TarefaAcessaBancoAoContrario(poll, tx), "Thread 2").
                start();

    }


}
