package estudos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class reducers {
    public static void main(String[] args) {

        List<Object> lista = new ArrayList<>();

        Object p1 = new Object() {
            private String name = "JOAO" +" DATA: "+ LocalDate.now();

            @Override
            public String toString() {
                return name;
            }
        };

        lista.add(p1);
        lista.add(p1);
        lista.add(p1);


        System.out.println(lista.get(1));
        Optional<String> x1 = lista.stream()
                .map(p -> p.toString())
                .reduce((s1, s2) -> s1+""+s2);
        System.out.println(x1);

    }
}



