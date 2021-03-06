package thread.servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Conexao estabelecida");

        Thread mensagemSaida = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    PrintStream saida = new PrintStream(socket.getOutputStream());
                    Scanner teclado = new Scanner(System.in);
                    while (teclado.hasNextLine()) {
                        String texto = teclado.nextLine();
                        if (texto.trim().equals("")) {
                            break;
                        }
                        saida.println(texto);
                    }
                    System.out.println("Cliente finalizado");
                    saida.close();
                    teclado.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread entrada = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("...aguardando resposta do servidor");
                    Scanner respostaServidor = new Scanner(socket.getInputStream());
                    while (respostaServidor.hasNextLine()) {
                        System.out.println(respostaServidor.nextLine());
                    }
                    respostaServidor.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        entrada.start();
        mensagemSaida.start();
        mensagemSaida.join();
        socket.close();
    }
}
