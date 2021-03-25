package thread.servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistribuirTarefas implements Runnable {


    private Socket socket;

    public DistribuirTarefas(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("THREAD EXECUTANDO " + Thread.currentThread().getName() + "  " + socket.getPort());
            Scanner entradaCliente = new Scanner(socket.getInputStream());
            PrintStream saidaCliente = new PrintStream(socket.getOutputStream());
            while (entradaCliente.hasNextLine()) {
                String comando = entradaCliente.nextLine();
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

                }
            }
            entradaCliente.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
