package thread.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainServidor {
    private ServerSocket servidor;
    private ExecutorService threadPoll;
    private AtomicBoolean estaRodando;
    private BlockingQueue<String> filaComando;

    public MainServidor() throws IOException {
        this.servidor = new ServerSocket(12345);
        this.threadPoll = Executors.newFixedThreadPool(4, new FabricaDeThreads());
        this.estaRodando = new AtomicBoolean(true);
        this.filaComando = new ArrayBlockingQueue<>(3);

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
                threadPoll.execute(new DistribuirTarefas(socket, this, threadPoll, filaComando));
                //  Thread thread = new Thread(new DistribuirTarefas(socket), String.valueOf(socket.getPort()));
                //  thread.start();
            } catch (SocketException e) {
                System.out.println("Finalizando servidor. Servidor rodando= " + estaRodando);

            }
        }
    }

    public void parar() throws IOException {
        this.estaRodando.set(false);

        servidor.close();
        threadPoll.shutdown();

    }
}
