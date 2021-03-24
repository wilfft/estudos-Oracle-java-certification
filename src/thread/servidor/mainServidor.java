package thread.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class mainServidor {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("---------Iniciando Servidor----------");

        while (true) {
            //aceitando conexoes
            Socket socket = servidor.accept();
            System.out.println("Aceitando cliente da porta: " + socket.getPort());
            Thread thread = new Thread(new DistribuirTarefas(socket), String.valueOf(socket.getPort()));
            thread.start();


        }


    }
}
