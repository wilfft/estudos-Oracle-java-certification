package shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import static shop.Avaliacao.NAO_AVALIADO;

public class Produto {

    public static final BigDecimal TAXA_DESCONTO = BigDecimal.valueOf(0.1);
    private int id;
    private String nome;
    private BigDecimal preco;
    private Avaliacao avaliacao;

    public Produto() {
        this(0, "sem nome", BigDecimal.ZERO);

    }

    public Produto(int id, String nome, BigDecimal preco, Avaliacao avaliacao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.avaliacao = avaliacao;

    }

    public Produto(int id, String nome, BigDecimal preco) { //REUTILIZANDO O CONSTRUTOR ADICIONANDO A AVALIACAO
        this(id, nome, preco, NAO_AVALIADO); //CHAMA O CONSTRUTOR ACIMA PASSANDO AS VARIAVEIS
    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;

    }

    public BigDecimal getPreco() {
        return preco;
    }

    public BigDecimal getDesconto() {
        return preco.multiply(TAXA_DESCONTO).setScale(2, RoundingMode.HALF_UP);
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public Produto aplicarAvaliacao(Avaliacao novaAvaliacao) {
        return new Produto(this.id, this.nome, this.preco, novaAvaliacao);
    }

    @Override
    public String toString() {
        return id + " " + nome + " " + preco + " " + getDesconto() + " " + getAvaliacao().getEstrelas();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        };
        //if (obj != null && getClass() == obj.getClass()) {

            if (obj instanceof Produto){
            Produto outro = (Produto) obj;
            System.out.println(">>> "+outro+ " \n"+ this+ " FIM EQUALS");
            return  outro.id == this.id && Objects.equals(this.nome, outro.nome);
        }
        return false;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash * this.id;
        return hash;
    }
}