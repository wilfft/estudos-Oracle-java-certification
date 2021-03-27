package thread.servidor.threads;

import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2Banco implements Callable {
    @Override
    public String call() throws InterruptedException {
        System.out.println("gerando calculo no banco");
        int senhaBanco = new Random().nextInt(1000) + 1;
        String retornoBanco = Integer.toString(senhaBanco);
        Thread.sleep(5000);
        return "Retorno futuro do Banco: " + retornoBanco;
    }
}
