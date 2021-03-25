package thread.servidor.servidorProprio;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TarefasServidor implements Runnable {

    private Socket socket;
    private ServidorMain servidor;


    public TarefasServidor(Socket socket, ServidorMain servidor) {
        this.socket = socket;
        this
                .servidor = servidor;
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


