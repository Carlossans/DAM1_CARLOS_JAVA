package E321ArrayListBasico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class E321ArrayListBasico {
    public static void main(String[] args) {
        // 1. Creación e inicialización
        ArrayList<String> frutas = new ArrayList<>();

        // 2. add(elemento): Añadir elementos
        frutas.add("Manzana");
        frutas.add("Banana");
        frutas.add("Pera");

        // 3. add(indice, elemento): Insertar en una posición específica
        frutas.add(1, "Mango"); // Ahora es: [Manzana, Mango, Banana, Pera]

        System.out.println("Lista inicial: " + frutas);

        // 4. get(indice): Acceder a un elemento
        String favorita = frutas.get(0);
        System.out.println("La primera fruta es: " + favorita);

        // 5. set(indice, elemento): Modificar un elemento
        frutas.set(2, "Arándano"); // Cambia Banana por Arándano

        // 6. size(): Tamaño de la lista
        System.out.println("Número de frutas: " + frutas.size());

        // 7. remove(indice) o remove(objeto): Eliminar
        frutas.remove(3); // Elimina "Pera"
        frutas.remove("Mango"); // Elimina por nombre

        // 8. contains(objeto): Verificar si existe algo
        if (frutas.contains("Manzana")) {
            System.out.println("¡La manzana sigue aquí!");
        }

        // 9. indexOf(objeto): Buscar la posición de un elemento
        int posicion = frutas.indexOf("Arándano");
        System.out.println("El arándano está en el índice: " + posicion);

        // --- TRABAJANDO CON UNA SEGUNDA LISTA ---

        ArrayList<String> citricos = new ArrayList<>(Arrays.asList("Limón", "Naranja"));

        // 10. addAll(coleccion): Unir listas
        frutas.addAll(citricos);
        System.out.println("Lista tras añadir cítricos: " + frutas);

        // 11. Collections.sort(): Ordenar la lista (alfabéticamente)
        Collections.sort(frutas);
        System.out.println("Lista ordenada: " + frutas);

        // 12. isEmpty(): ¿Está vacía?
        System.out.println("¿Está vacía la lista? " + frutas.isEmpty());

        // 13. clear(): Borrar todo el contenido
        citricos.clear();
        System.out.println("Cítricos después de clear(): " + citricos.size());
    }
}
