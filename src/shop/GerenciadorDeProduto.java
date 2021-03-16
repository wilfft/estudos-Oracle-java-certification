package shop;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GerenciadorDeProduto {

    public Produto criarProduto(int id,
                                String nome,
                                BigDecimal preco,
                                Avaliacao avaliacao, LocalDate venceEm) {

        return new Comida(id, nome, preco, avaliacao, venceEm);
    }

    public Produto criarProduto(int id,
                                String nome,
                                BigDecimal preco,
                                Avaliacao avaliacao) {

        return new Bebida(id, nome, preco, avaliacao);
    }
}
