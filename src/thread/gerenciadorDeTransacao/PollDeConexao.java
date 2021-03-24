package thread.gerenciadorDeTransacao;

public class PollDeConexao {

    public String getConnection() throws InterruptedException {
        System.out.println("emprestando conexao");
        Thread.sleep(5000);

        return "Conexao";
    }
}
