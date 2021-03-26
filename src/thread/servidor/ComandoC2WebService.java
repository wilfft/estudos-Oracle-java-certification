package thread.servidor;

import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2WebService implements Callable {
    @Override
    public String call() throws Exception {

        System.out.println("gerando calculo no webservice");
        int codigoWeb = new Random().nextInt(100) + 1;
        String retorno = Integer.toString(codigoWeb);
        Thread.sleep(5400);
        return "Codigo de futuro do webService:" + retorno;
    }
}
