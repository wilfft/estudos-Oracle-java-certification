package thread.banheiro;

public class thread {
    public static void main(String[] args) throws InterruptedException {

        Banheiro banheiro = new Banheiro();
        Thread t1 = new Thread(new numero1(banheiro), "João");
        Thread Faxineira = new Thread(new Limpeza(banheiro), "Faxineira");
        Thread t2 = new Thread(new numero2(banheiro), "Theo");

        t1.start();
        t2.start();
        Faxineira.setDaemon(true);
        Faxineira.start();


    }


}
