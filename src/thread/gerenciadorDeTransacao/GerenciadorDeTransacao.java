package thread.gerenciadorDeTransacao;

public class GerenciadorDeTransacao {

    public void begin() throws InterruptedException {
        System.out.println("Começando a transão");
        Thread.sleep(5000);


    }
}
