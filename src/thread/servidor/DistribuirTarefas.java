package thread.servidor;

import java.net.Socket;

public class DistribuirTarefas implements Runnable {


    private Socket socket;

    public DistribuirTarefas(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        System.out.println("THREAD EXECUTANDO " + Thread.currentThread().getName() + "  " + socket.getPort());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
