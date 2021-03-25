package thread.servidor.servidorProprio;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException, InterruptedException {
        final String nome;


            Socket socket = new Socket("localhost", 12345);


        Thread mensagemSaida = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    PrintStream saida = new PrintStream(socket.getOutputStream());
                    Scanner teclado = new Scanner(System.in);


                    while (teclado.hasNextLine()) {
                        String text = teclado.nextLine();

                        if (text.trim().equals("")) {
                            break;
                        }
                        saida.println(text);
                    }
                    saida.close();
                    teclado.close();
                } catch (IOException e) {
                    System.out.println("Servidor não está rodando");
                }

            }
        });
        Thread mensagemEntrada = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("aguardando resposta do servidor....");
                    Scanner respostaServidor = new Scanner(socket.getInputStream());
                    while (respostaServidor.hasNextLine()) {
                        System.out.println(respostaServidor.nextLine());
                    }
                    respostaServidor.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        mensagemSaida.start();
        mensagemEntrada.start();
        mensagemEntrada.join();

        socket.close();
    }
}
