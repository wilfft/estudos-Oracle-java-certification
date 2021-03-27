package thread.servidor;

import thread.servidor.threads.DistribuirTarefas;
import thread.servidor.threads.TarefaConsumirThread;
import thread.servidor.threads.TarefaProcessandoHTTP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainServidor {
    private ServerSocket servidor;
    private ExecutorService threadPoll;
    private AtomicBoolean estaRodando;
    private BlockingQueue<String> filaComando;
    private PriorityBlockingQueue<ComandoClass> filaHTTP;

    public MainServidor() throws IOException, InterruptedException {
        this.servidor = new ServerSocket(12345);
        this.threadPoll = Executors.newFixedThreadPool(4, new FabricaDeThreads());
        this.estaRodando = new AtomicBoolean(true);
        this.filaComando = new ArrayBlockingQueue<>(2);
        this.filaHTTP = new PriorityBlockingQueue<ComandoClass>();

        iniciarConsumidor();
        iniciarConsumirHTTP();

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Servidor rodando...");
        MainServidor mainServidor = new MainServidor();
        mainServidor.iniciar();
        mainServidor.parar();
    }

    public void iniciar() throws IOException {
        while (estaRodando.get()) {
            //aceitando conexões
            try {
                Socket socket = servidor.accept();
                System.out.println("Aceitando cliente da porta: " + socket.getPort());
                threadPoll.execute(new DistribuirTarefas(socket, this, threadPoll, filaComando, filaHTTP));
                //  Thread thread = new Thread(new DistribuirTarefas(socket), String.valueOf(socket.getPort()));
                //  thread.start();
            } catch (SocketException e) {
                System.out.println("Finalizando servidor. Servidor rodando= " + estaRodando);

            }
        }
    }

    private void iniciarConsumidor() {
        int qtdeConsumidores = 2;
        for (int i = 0; i < qtdeConsumidores; i++) {
            TarefaConsumirThread tarefa = new TarefaConsumirThread(filaComando);
            this.threadPoll.execute(tarefa);
        }
    }

    private void iniciarConsumirHTTP() {
        int qtdeConsumidores = 1;
        for (int i = 0; i < qtdeConsumidores; i++) {

            TarefaProcessandoHTTP http = new TarefaProcessandoHTTP(filaHTTP);
            this.threadPoll.execute(http);
        }
    }

    public void parar() throws IOException {
        this.estaRodando.set(false);
        servidor.close();
        threadPoll.shutdown();

    }

    /*private void teste() throws InterruptedException {

        ComandoClass comando = null;
        while ((comando = filaHTTP.take()) != null) {
            System.out.println(comando.getNome() + " - " + comando.getPrioridade());
        }*/
}

