import shop.Avaliacao;
import shop.GerenciadorDeProduto;
import shop.Produto;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.logging.Logger;

public class main {
  //  private static Logger logger  = Logger.getLogger(src.Class.getName());

    public static void main(String[] args) {


        GerenciadorDeProduto gm = new GerenciadorDeProduto(Locale.US);
        Produto p1 = gm.criarProduto(101, "Chá", BigDecimal.valueOf(1.99), Avaliacao.NAO_AVALIADO);
        gm.printProdutoReport();
        p1 = gm.reviewProduto(p1, Avaliacao.CINCO_ESTRELAS, "Bom mas sem açucar");
         p1 = gm.reviewProduto(p1, Avaliacao.CINCO_ESTRELAS, "gostei muito bom");
       // p1 = gm.reviewProduto(p1, Avaliacao.CINCO_ESTRELAS, "nao gostei muito");


        gm.printProdutoReport();
     /*   Produto p2 = gm.criarProduto(102, "Refrigenrante", BigDecimal.valueOf(1.99), Avaliacao.QUATRO_ESTRELAS);
        Produto p3 = gm.criarProduto(103, "Bolo", BigDecimal.valueOf(1.99),
                Avaliacao.CINCO_ESTRELAS, LocalDate.now().plusDays(2));

        //p3.getVenceEm(); //se a type é produto nao tenho vence em
        //  if (p3 instanceof Comida) {
        //      System.out.println(((Comida) p3).getVenceEm()); //mas se eu usar o casting, consigo }
        //  System.out.println("DIRETO DO P3 PRODUITO  "+p3.getVenceEm()); // ao colocar o metodo getVenceEm tbm no produto, agora posso usa-lo[
        // Produto p4 =  gm.criarProduto();
        Produto p5 = p3.aplicarAvaliacao(Avaliacao.CINCO_ESTRELAS);
        Produto p6 = gm.criarProduto(104, "Chocolate", BigDecimal.valueOf(1.99), Avaliacao.QUATRO_ESTRELAS, LocalDate.now().plusDays(2));
        Produto p7 = gm.criarProduto(104, "Chocolate", BigDecimal.valueOf(1.99), Avaliacao.TRES_ESTRELAS);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p5);
        System.out.println(p6);
        System.out.println(p7);
        //  System.out.println("p6.equals(p7)  " + p6.equals(p7));
        System.out.print("hello");*/
    }


}
