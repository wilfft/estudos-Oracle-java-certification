package shop;

public enum Avaliacao {
    NAO_AVALIADO("☆☆☆☆☆"),
    CINCO_ESTRELAS("★★★★★"),
    QUATRO_ESTRELAS("★★★★☆"),
    TRES_ESTRELAS("★★★☆☆"),
    DUAS_ESTRELAS("★★☆☆☆"),
    UMA_ESTRELAS("★☆☆☆☆");


    private String estrelas;

    Avaliacao(String estrelas) {
        this.estrelas = estrelas;
    }

    public String getEstrelas() {
        return estrelas;
    }
    }
