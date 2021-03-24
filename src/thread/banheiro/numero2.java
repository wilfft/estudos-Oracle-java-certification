package thread.banheiro;

public class numero2 implements Runnable {
    private Banheiro banheiro;

    public numero2(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        banheiro.fazNumero2();

    }


}
