package thread.servidor.servidorProprio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorMain {
    private ServerSocket servidor;
    private ExecutorService threadPoll;
    boolean estaRodando = true;

    public ServidorMain() throws IOException {
        this.threadPoll = Executors.newCachedThreadPool();
        this.servidor = new ServerSocket(12345);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ServidorMain servidorMain = new ServidorMain();
        new Thread(() -> {
            System.out.println("LAMBDA");
        }).start();

        servidorMain.iniciar();
        servidorMain.parar();


    }

    public void iniciar() throws IOException {
        System.out.println("Servidor running...");
        try {
            while (this.estaRodando) {
                Socket socket = servidor.accept();
                System.out.println("conexão recebida: " + socket.getPort());
                threadPoll.execute(new TarefasServidor(socket, this));
            }
        } catch (SocketException e) {
            System.out.println("esta rodando ainda " + estaRodando);
        }
    }


    public void parar() throws IOException {
        estaRodando = false;
        servidor.close();
        threadPoll.shutdown();


    }
}
