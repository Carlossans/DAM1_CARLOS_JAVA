package b400OOAVANZADA.b40000avanzada.Animales.E420InterfazParlante;

public class Perezoso extends Mamifero implements Parlante {
    public static final int APROVECHAMIENTO_COMIDA = 9;

    public Perezoso(String nombre) {
        super(APROVECHAMIENTO_COMIDA, nombre);
    }

    public Perezoso(String nombre, int energia) {
        super(APROVECHAMIENTO_COMIDA, nombre, energia);
    }

    public void habla() {
        String habla;

        if (energia < 30) habla = "hhh....";
        else if (energia <= 70) habla = "hmmmmmm";
        else habla = "¡HMMM HMMMMM!";

        System.out.println(habla);

        gastarEnergiaPorHablar();
    }
}