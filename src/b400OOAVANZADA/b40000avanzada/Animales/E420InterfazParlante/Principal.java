package b400OOAVANZADA.b40000avanzada.Animales.E420InterfazParlante;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<Animal> animales = new ArrayList<>();
        animales.add(new Gato("Garfield", 20));
        animales.add(new Perro("Pluto"));
        animales.add(new Pajaro("Piolín", 80));
        animales.add(new Perezoso("Lily"));
        animales.add(new Rana("Gustavo", 50));

        while (true) {
            for (Animal animal : animales) {
                animal.habla();

                if (Math.random() < 0.30) {
                    int cantidad = (int) (Math.random() * 3) + 1;
                    animal.come(cantidad);
                    System.out.printf("%s come %d.\n", animal, cantidad);
                } else {
                    System.out.println();
                }
            }

            System.out.println("-----------");
        }
    }
}