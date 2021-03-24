package thread.servidor;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Conexao estabelecida");

        Scanner teclado = new Scanner(System.in);
        String texto = teclado.nextLine();
        System.out.println("Voce digitou " + texto);
        socket.close();
    }
}
