package thread.servidorProprio;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class TarefasServidor implements Runnable {

    private Socket socket;
    private ServidorMain servidor;
    private ExecutorService threadPoll;

    public TarefasServidor(Socket socket, ServidorMain servidor, ExecutorService threadPoll) {
        this.socket = socket;
        this.servidor = servidor;
        this.threadPoll = threadPoll;
    }

    @Override
    public void run() {
        try {
            Scanner entrada = new Scanner(socket.getInputStream());
            PrintStream saida = new PrintStream(socket.getOutputStream());
            System.out.println("THREAD LIGADA:  " + Thread.currentThread().getName());
            System.out.println("PORTA:  " + socket.getPort());

            while (entrada.hasNextLine()) {
                String comando = entrada.nextLine();
                System.out.println("COMANDO ENVIADO PELO CLIENTE: " + comando);
                switch (comando) {
                    case "c1":
                        saida.println("COMANDO C1");
                        ComandoC1 c1 = new ComandoC1(saida);

                        threadPoll.execute(c1);
                        break;
                    case "c2":
                        saida.println("COMANDO C2");
                        break;
                    case "exit":
                        saida.println("Finalizando sistema");
                        servidor.parar();

                        break;
                    default:
                        saida.println("COMANDO NAO ENCONTRADO");
                        break;
                }
                // saida.println(entrada.nextLine());
                // System.out.println(entrada.nextLine());
            }
            entrada.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


