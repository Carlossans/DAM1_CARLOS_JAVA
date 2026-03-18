package b400OOAVANZADA.b40000avanzada.Animales.E420InterfazParlante;

public class Perro extends Mamifero implements Parlante {
    public static final int APROVECHAMIENTO_COMIDA = 7;

    public Perro(String nombre) {
        super(APROVECHAMIENTO_COMIDA, nombre);
    }

    public Perro(String nombre, int energia) {
        super(APROVECHAMIENTO_COMIDA, nombre, energia);
    }

    public void habla() {
        String habla;

        if (energia < 30) habla = "grrrr....";
        else if (energia <= 70) habla = "guau";
        else habla = "¡GUAU GUAUUUUUU!";

        System.out.println(habla);

        gastarEnergiaPorHablar();
    }
}