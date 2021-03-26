package thread.servidor;

import java.util.concurrent.ThreadFactory;

public class FabricaDeThreads implements ThreadFactory {

    private static int numero = 1;

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, "Tread Servidor de Tarefas" + numero);
        thread.setUncaughtExceptionHandler(new TratadorDeExcecoes());
        numero++;
        return thread;
    }
}
