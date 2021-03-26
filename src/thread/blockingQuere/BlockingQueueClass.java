package thread.blockingQuere;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueClass {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> fila = new ArrayBlockingQueue<>(3);
        fila.offer("Ola");
        fila.offer("Ola");
        fila.offer("Ola");

        System.out.println("TESTE +" + fila.take());

        System.out.println("TESTE +" + fila.take());

        System.out.println("TESTE +" + fila.take());

        System.out.println("TESTE +" + fila.take());
        fila.offer("OOOO");
        System.out.println("TESTE +" + fila.take());

        System.out.println(fila.size());


    }

}
