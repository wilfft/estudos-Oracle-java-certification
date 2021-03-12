import shop.Avaliacao;
import shop.Bebida;
import shop.Comida;
import shop.Produto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class main {

    public static void main(String[] args) {
        Produto p1 = new Produto(101, "Chá", BigDecimal.valueOf(1.99));
        Produto p2 = new Produto(102, "Refrigenrante", BigDecimal.valueOf(1.99));
        Produto p3 = new Comida(103, "Bolo", BigDecimal.valueOf(1.99),
                Avaliacao.CINCO_ESTRELAS, LocalDate.now().plusDays(2));
        //p3.getVenceEm();
        ((Comida) p3).getVenceEm();
        Produto p4 = new Produto();
        Produto p5 = p3.aplicarAvaliacao(Avaliacao.CINCO_ESTRELAS);
        Produto p6 = new Comida(104, "Chocolate", BigDecimal.valueOf(1.99),Avaliacao.QUATRO_ESTRELAS ,LocalDate.now().plusDays(2));
        Produto p7 = new Bebida(104, "Chocolate", BigDecimal.valueOf(1.99),Avaliacao.TRES_ESTRELAS);
        Produto p8 = new Bebida(104, "Chocolate", BigDecimal.valueOf(2.99),Avaliacao.DUAS_ESTRELAS);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
        System.out.println(p7);
       System.out.println("p1 com p2  "+ p1.equals(p2));

        System.out.println("p3.equals(p6)  "+p3.equals(p6));
        System.out.println("p6.equals(p7)  "+p6.equals(p7));

        System.out.println("p6.equals(p7)  "+p8.equals(p7));
    }


}
