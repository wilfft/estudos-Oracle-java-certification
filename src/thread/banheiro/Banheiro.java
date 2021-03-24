package thread.banheiro;

public class Banheiro {

    Boolean estaSujo = true;


    public void fazNumero1() {

        String nome = Thread.currentThread().getName();
        System.out.println(nome + " : Esta batendo na porta");

        synchronized (this) {
            if (estaSujo) {

                System.out.println(nome + " diz: eca, está sujo");
                System.out.println(nome + " saiu do banheiro");
                esperarLaFora();
            }
            System.out.println(nome + " está batendo na porta");
            dormir(2000);

            System.out.println(nome + " abriu a porta");
            dormir(1000);

            System.out.println(nome + " está fazendo xixi");
            dormir(3000);

            System.out.println(nome + " lavando as mãos");
            dormir(1000);

            System.out.println(nome + " saiu do banheiro");
            estaSujo = true;
        }
    }


    public void fazNumero2() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " : Esta batendo na porta");

        synchronized (this) {
            if (estaSujo) {

                System.out.println(nome + " diz: eca, está sujo");
                System.out.println(nome + " saiu do banheiro");
                esperarLaFora();
            }
            System.out.println(nome + " está batendo na porta");
            dormir(2000);

            System.out.println(nome + " abriu a porta");
            dormir(1000);

            System.out.println(nome + " está fazendo xixi");
            dormir(3000);

            System.out.println(nome + " lavando as mãos");
            dormir(1000);

            System.out.println(nome + " saiu do banheiro");
            estaSujo = true;
        }
    }

    private void esperarLaFora() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void dormir(int segundos) {
        try {
            Thread.sleep(segundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void limpar() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " Batendo na porta");
        synchronized (this) {
            System.out.println(nome + " está entrando no banheiro");
            if (!estaSujo) {

                System.out.println(nome + " nao viu nada sujo, esta saindo do banheiro");
                return
                        ;
            }
            System.out.println(nome + " está limpando o banheiro");
            this.estaSujo = false;
            dormir(5000);


            System.out.println(nome + " está saindo no banheiro");
            notifyAll();
        }

    }
}
