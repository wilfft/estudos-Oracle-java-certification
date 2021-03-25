package thread.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class mainServidor {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("---------Iniciando Servidor----------");

        while (true) {
            //aceitando conexões
            Socket socket = servidor.accept();
            System.out.println("Aceitando cliente da porta: " + socket.getPort());
            ExecutorService threadPoll = Executors.newCachedThreadPool();
            threadPoll.execute(new DistribuirTarefas(socket));
            //  Thread thread = new Thread(new DistribuirTarefas(socket), String.valueOf(socket.getPort()));
            //  thread.start();
        }
    }
}
