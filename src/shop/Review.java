package shop;

public class Review {

    private String comentario;
    private Avaliacao avaliacao;

    public Review(  Avaliacao avaliacao,String comentario) {
        this.comentario = comentario;
        this.avaliacao = avaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    @Override
    public String toString() {
        return "Review{" +
                "comentario='" + comentario + '\'' +
                ", avaliacao=" + avaliacao +
                '}';
    }
}
