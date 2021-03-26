package thread.servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class DistribuirTarefas implements Runnable {


    private Socket socket;
    private MainServidor servidor;
    private ExecutorService threadPoll;
    private BlockingQueue<String> fila;

    public DistribuirTarefas(Socket socket, MainServidor servidor, ExecutorService threadPoll, BlockingQueue<String> fila) {
        this.socket = socket;
        this.servidor = servidor;
        this.threadPoll = threadPoll;
        this.fila = fila;

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
                        threadPoll.execute(new ComandoC1(saidaCliente));
                        break;

                    case "c2":
                        saidaCliente.println("Comando escolhido: c2");

                        Future<String> c2WebServer = threadPoll.submit(new ComandoC2WebService());
                        Future<String> c2Banco = threadPoll.submit(new ComandoC2Banco());
                        this.threadPoll.submit(new JuntaWebComBanco(c2WebServer, c2Banco, saidaCliente));
                        break;

                    case "c3":
                        this.fila.put(comando);
                        saidaCliente.println("Comando c3 adicionado a fila");
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

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
