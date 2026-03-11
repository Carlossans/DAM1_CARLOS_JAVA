package b400OOAVANZADA.b40000avanzada.Animales;

import java.util.ArrayList;
import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Animal> animales = new ArrayList<>();

        animales.add(new Perro(100));
        animales.add(new Gato(80));
        animales.add(new Pajaro(90));
        animales.add(new Pez(70));
        animales.add(new Canario(85));

        Random aleatorio = new Random();

        while (true) {
            for (Animal animal : animales) {
                if (Math.random() < 0.30) {
                    int cantidadComida = aleatorio.nextInt(3) + 1;
                    int energiaAnterior = animal.getEnergia();
                    animal.come(aleatorio.nextInt(3) + 1);
                    System.out.printf("El %s ha comido %d unidad(es). Energía %d --> %d", animal.getClass().getSimpleName(), cantidadComida, energiaAnterior, animal.getEnergia());
                }
            }

            System.out.println("\nLos animales hablan:");
            for (Animal animal : animales) {
                int energiaAntes = animal.getEnergia();
                animal.habla();
                System.out.printf(" %s: energía %d --> %d",animal.getClass().getSimpleName(), energiaAntes, animal.getEnergia() );
            }
        }
    }
}