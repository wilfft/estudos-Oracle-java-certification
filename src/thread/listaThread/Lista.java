package thread.listaThread;

public class Lista {

    private String[] elementos = new String[1000];
    private int indice = 0;

    public synchronized void adicionaElementos(String elemento) {

        this.elementos[indice] = elemento;
        this.indice++;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (tamanho() == indice) {
            System.out.println("Lista preenchida, notificando");
            this.notify();
        }

    }

    public int tamanho() {
        return this.elementos.length;
    }

    public String pegaElementos(int posicao) {
        return this.elementos[posicao];
    }

    public boolean estaCheia() {
        return this.tamanho() == this.indice;
    }
}
