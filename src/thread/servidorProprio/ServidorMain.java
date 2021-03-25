package thread.servidorProprio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorMain {
    private ServerSocket servidor;
    private ExecutorService threadPoll;
    boolean estaRodando = true;

    public ServidorMain() throws IOException {
        this.threadPoll = Executors.newCachedThreadPool();
        this.servidor = new ServerSocket(12345);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ServidorMain servidorMain = new ServidorMain();
        Thread lambda = new Thread(() -> {
            System.out.println("ESTADO:" + Thread.currentThread().getState() + "  "
                    + " VIVA?:" + Thread.currentThread().isAlive());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("thread interrompida e voltando ao runnbal");
                return;
            }

        }, "threadLambida");
        lambda.start();
        Thread.State estado = lambda.getState();
        lambda.interrupt();
        Thread.State estado2 = lambda.getState();
        System.out.println("ESTADO" + estado2);
        System.out.println("lambda id: " + lambda.getId());
        lambda.setPriority(10);
        lambda.join(); //so encerra se essa thread main encerrar
        System.out.println(lambda.isDaemon());

        servidorMain.iniciar();

        lambda.setDaemon(true); //:Encerra quando todas as outros threads encerrarem
        System.out.println(lambda.isDaemon());
        servidorMain.parar();


    }

    public void iniciar() throws IOException {
        System.out.println("Servidor running...");
        try {
            while (this.estaRodando) {
                Socket socket = servidor.accept();
                System.out.println("conexão recebida: " + socket.getPort());
                threadPoll.execute(new TarefasServidor(socket, this, threadPoll));
            }
        } catch (SocketException e) {
            System.out.println("esta rodando ainda " + estaRodando);
        }
    }


    public void parar() throws IOException {
        estaRodando = false;
        servidor.close();
        threadPoll.shutdown();


    }
}
