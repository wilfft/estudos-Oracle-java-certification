package thread.servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistribuirTarefas implements Runnable {


    private Socket socket;
    private MainServidor servidor;

    public DistribuirTarefas(Socket socket, MainServidor servidor) {
        this.socket = socket;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        try {
            System.out.println("THREAD EXECUTANDO " + Thread.currentThread().getName() + "  " + socket.getPort());
            Scanner entradaCliente = new Scanner(socket.getInputStream());
            PrintStream saidaCliente = new PrintStream(socket.getOutputStream());
            while (entradaCliente.hasNextLine()) {
                String comando = entradaCliente.nextLine();

                System.out.println("Comando digitado " + comando);

                switch (comando) {
                    case "c1":
                        saidaCliente.println("Comando escolhido: " + comando);
                        break;

                    case "c2":
                        saidaCliente.println("Comando escolhido: c2");
                        break;
                    case "c3":
                        saidaCliente.println("Comando escolhido: c3");
                        break;
                    case "exit":
                        saidaCliente.println("Finalizando sistema");
                   // entradaCliente.close();
                        servidor.parar();
                        break;

                    default:
                        saidaCliente.println("Comando nao reconhecido!");
                        break;

                }
            }
            entradaCliente.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
