package shop;

public interface Avalidora<T> {

    public static final Avaliacao DEFAULT_RATING = Avaliacao.NAO_AVALIADO; // Constante

    /*public abstract */
    T aplicarAvaliacao(Avaliacao avaliacao);


    public static Avaliacao converte(int estrelas) {
        return (estrelas >= 0 && estrelas <= 0 ? Avaliacao.values()[estrelas] : DEFAULT_RATING);
    }

    public default T aplicarAvaliacao(int estrelas) {
        return aplicarAvaliacao(converte(estrelas));
    }


    public  default Avaliacao getAvaliacao() {
        return DEFAULT_RATING;
    }


}
