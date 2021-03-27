package thread.servidor.threads;

import thread.servidor.ComandoClass;
import thread.servidor.MainServidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;

public class DistribuirTarefas implements Runnable {


    private Socket socket;
    private MainServidor servidor;
    private ExecutorService threadPoll;
    private BlockingQueue<String> fila;
    private PriorityBlockingQueue<ComandoClass> filaHTTP;

    public DistribuirTarefas(Socket socket, MainServidor servidor, ExecutorService threadPoll, BlockingQueue<String> fila, PriorityBlockingQueue<ComandoClass> filaHTTP) {
        this.socket = socket;
        this.servidor = servidor;
        this.threadPoll = threadPoll;
        this.fila = fila;
        this.filaHTTP = filaHTTP;

    }

    @Override
    public void run() {
        try {
            System.out.println("THREAD EXECUTANDO " + Thread.currentThread().getName() + "  " + socket.getPort());
            Scanner entradaCliente = new Scanner(socket.getInputStream());
            PrintStream saidaCliente = new PrintStream(socket.getOutputStream());
            while (entradaCliente.hasNextLine()) {
                String comando = entradaCliente.nextLine();
                ComandoClass http;

                System.out.println("Comando digitado " + comando);

                switch (comando) {
                    case "c1":
                        saidaCliente.println("Comando escolhido: " + comando);
                        threadPoll.execute(new ComandoC1(saidaCliente));
                        break;

                    case "ADD":

                        saidaCliente.println("ADD");

                        http = new ComandoClass("comando enviado ADD",
                                5,
                                "curso=threads2&dataCriacao=12/06/2016&nivel=avanca");
                        this.filaHTTP.put(http);
                        saidaCliente.println(http.toString());
                        System.out.println(filaHTTP.size());
                        break;

                    case "UPDATE":
                        http = new ComandoClass("UPDATE", 1, "curso=threads2&dataCriacao=13/06/2016");
                        this.filaHTTP.put(http);
                        saidaCliente.println(http.toString());
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
