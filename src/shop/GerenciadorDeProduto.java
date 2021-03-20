package shop;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class GerenciadorDeProduto {

    private Locale locale;
    private ResourceBundle resources;
    private DateTimeFormatter formataData;
    private NumberFormat formataDinheiro;

    private Produto produto;
    private Review[] reviews = new Review[5];

    public GerenciadorDeProduto(Locale locale) {
        this.locale = locale;
        resources = ResourceBundle.getBundle("shop.resources", locale);
        formataData = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).localizedBy(locale);
        formataDinheiro = NumberFormat.getCurrencyInstance(locale);


    }

    public Produto criarProduto(int id,
                                String nome,
                                BigDecimal preco,
                                Avaliacao avaliacao, LocalDate venceEm) {
        produto = new Comida(id, nome, preco, avaliacao, venceEm);

        return produto;

    }

    public Produto criarProduto(int id,
                                String nome,
                                BigDecimal preco,
                                Avaliacao avaliacao) {
        produto = new Bebida(id, nome, preco, avaliacao);
        return produto;
    }

    public Produto reviewProduto(Produto produto, Avaliacao avaliacao, String comentario) {
        // reviews = new Review(avaliacao, comentario);
        if (reviews[reviews.length - 1] != null) {
            reviews = Arrays.copyOf(reviews, reviews.length + 5);
        }
        int sum = 0, i = 0;
        boolean reviewed = false;
        while (i < reviews.length && !reviewed) {
            if (reviews[i] == null) {
                reviews[i] = new Review(avaliacao, comentario);
                reviewed = true;
            }
            sum += reviews[i].getAvaliacao().ordinal();
            i++;
        }

        this.produto = produto.aplicarAvaliacao(Avalidora.converte(Math.round((float) sum / i)));
        // this.produto = produto.aplicarAvaliacao(avaliacao);
        return this
                .produto;
    }

    public void printProdutoReport() {
        StringBuilder txt = new StringBuilder();
        txt.append(MessageFormat.format(resources.getString("produto"),
                produto.getNome(),
                formataDinheiro.format(produto.getPreco()),
                produto.getAvaliacao().getEstrelas(),
                formataData.format(produto.getVenceEm())));
        txt.append("\n");
        for (Review reviews : reviews) {
            if (reviews == null) {
                break;
            }
            txt.append(MessageFormat.format(resources.getString("review"),
                    reviews.getAvaliacao().getEstrelas(),
                    reviews.getComentario()));
            txt.append("\n");
        }
        if (reviews[0] == null) {
            txt.append(resources.getString("no.reviews"));
            txt.append("\n");
        }
        System.out.println(txt);
    }


}

