package E321ArrayListBasico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class E321ArrayListBasico {
    public static void main(String[] args) {
        ArrayList<String> frutas = new ArrayList<>();

        frutas.add("Manzana");
        frutas.add("Banana");
        frutas.add("Pera");


        frutas.add(1, "Mango");

        System.out.println("Lista inicial: " + frutas);

        String favorita = frutas.getFirst(); // cambio de frutas.get(0);
        System.out.println("La primera fruta es: " + favorita);

        frutas.set(2, "Arándano");

        System.out.println("Número de frutas: " + frutas.size());

        frutas.remove(3);
        frutas.remove("Mango");

        if (frutas.contains("Manzana")) {
            System.out.println("La manzana sigue aquí");
        }

        int posicion = frutas.indexOf("Arándano");
        System.out.println("El arándano está en el índice: " + posicion);

        ArrayList<String> citricos = new ArrayList<>(Arrays.asList("Limón", "Naranja"));

        frutas.addAll(citricos);
        System.out.println("Lista tras añadir cítricos: " + frutas);

        Collections.sort(frutas);
        System.out.println("Lista ordenada: " + frutas);

        System.out.println("¿Está vacía la lista? " + frutas.isEmpty());

        citricos.clear();
        System.out.println("Cítricos después de clear(): " + citricos.size());
    }
}
