package shop;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Comida extends Produto {

    public LocalDate venceEm;

    public Comida(int id, String nome, BigDecimal preco, Avaliacao avaliacao, LocalDate venceEm) {
        super(id, nome, preco, avaliacao);
        this.venceEm = venceEm;
    }

    public LocalDate getVenceEm() {
        System.out.println(super.getNome()+ " vence em:" +venceEm);
        return venceEm;

    }

    @Override
    public String toString() {
        return super.toString()+", validade: " +venceEm;
    }
}
