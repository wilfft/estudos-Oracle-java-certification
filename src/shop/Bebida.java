package shop;

import java.math.BigDecimal;

  class  Bebida  extends Produto {
    public Bebida(int id, String nome, BigDecimal preco, Avaliacao avaliacao) {
        super(id, nome, preco, avaliacao);
    }

      @Override
      public Produto aplicarAvaliacao(Avaliacao novaAvaliacao) {
       return new Bebida(getId(),getNome(),getPreco(), novaAvaliacao);

      }
  }
