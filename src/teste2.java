import java.util.ArrayList;
import java.util.List;

class teste2 {


    public static List<Integer> calcula(int maxDigits) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        String sequencia = "";

        int soma = 0, resto = 0;

        for (int i = 0; i < 4; i++) {

            if ((soma + maxDigits <= 21)) {
                soma += maxDigits;
                sequencia = sequencia + maxDigits;
            } else {
                resto = 21 - soma;

                sequencia = sequencia + resto;
            }

        }

        String minimo = new StringBuilder(sequencia).reverse().toString();
        int inicio = Integer.valueOf(minimo); //remover os zeros da esquerda

        //  System.out.println("SEM ZERO> "+Integer.valueOf(minimo));
        // System.out.println("MAXIMO> " + Integer.toString(Integer.parseInt(minimo)));
        //System.out.println("MINIMO> " + minimo);

        if (Integer.toString(Integer.parseInt(minimo)).length() == 4 && sequencia.length() == 4) {
            System.out.println("MINIMO> " + inicio);
            System.out.println("MAXIMO> " + sequencia);
            loopInicioAoFim(minimo, sequencia, maxDigits);
        }

        System.out.println("MINIMO> " + minimo);
        System.out.println("MAXIMO> " + sequencia);
        return list;

    }

    private static int loopInicioAoFim(String inicio, String fim, int digito) { //RECEBE O INICIO E O FIM DO RANGE DE VERIFICACAO
        int start = Integer.valueOf(inicio);
        int end = Integer.valueOf(fim);

        for (int i = start; i <= end; i++) {
            soma21(i, digito);
        }
        return 0;
    }


  /*  private static boolean autoriza(Integer digito) {
       // int[] array = new int[4];

        int soma = 0, resto = 0;
        String sequencia = "";


        for (int i = 0; i < 4; i++) {

            if ((soma + digito < 21)) {
                soma += digito;
                System.out.println(soma);
                sequencia = sequencia + digito;
            } else {
                resto = 21 - soma;
                sequencia = sequencia + resto;
            }

        }

        return false;
    }*/


    //funçao que vai identificar os numeros que batem 21
    private static Integer soma21(Integer numeroAtual, Integer digito) {
        int soma = 0;
        char[] array = Integer.toString(numeroAtual).toCharArray();

        for (char a : array) {
            if (Integer.parseInt(String.valueOf(a)) <= digito) { //preciso limitar cada casa para ser igual ou menor que o digito
                soma += Integer.parseInt(String.valueOf(a));
                if (soma == 21) {
                    System.out.println(numeroAtual);
                    return numeroAtual;
                }
            }
        }
        return null;
    }


    public static void main(String[] args) {
        calcula(7);

        //     calcula(3);
    }

    int
            soma = 0;

// Percorre o tamanho de digitos fazendo o calculo.
/*for(
    int i = 0; i<numeros.length();i++)

    {
        soma += Integer.valueOf(numeros.substring(i, i + 1)).intValue();
    }

// Mostra o resultado.
System.out.println(soma);

}*/

/*for (int i = 0; i < s.length(); i++) {
        soma += s.charAt(i) - 48;
        }*/


}
