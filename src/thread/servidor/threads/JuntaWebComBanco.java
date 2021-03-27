package thread.servidor.threads;

import java.io.PrintStream;
import java.util.concurrent.*;

public class JuntaWebComBanco implements Callable<Void> {
    private Future<String> c2WebServer;
    private Future<String> c2banco;
    private PrintStream saida;

    public JuntaWebComBanco(Future<String> c2WebServer, Future<String> c2Banco, PrintStream saidaCliente) {
        this.c2WebServer = c2WebServer;
        this.c2banco = c2Banco;
        this.saida = saidaCliente;

    }


    @Override
    public Void call() {
        saida.println("Buscando dados no webService e no Banco... aguarde");


        try {
            String retornoBanco = c2banco.get(10, TimeUnit.SECONDS);
            String retornoWebService = c2WebServer.get(10, TimeUnit.SECONDS);
            saida.println("Retorno Banco: " + retornoBanco + "\n" + "Retorno WebService: " + retornoWebService);
            saida.println("Busca terminanda com sucesso");
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println("Timeout na solictaçao de dados pro banco ou webservice");
            c2WebServer.cancel(true);
            c2banco.cancel(true);
        }


        return null;


    }
}
