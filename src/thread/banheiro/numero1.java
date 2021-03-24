package thread.banheiro;

public class numero1 implements Runnable {

    private Banheiro banheiro;

    public numero1(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        banheiro.fazNumero1();

    }
}