package b400OOAVANZADA.b40000avanzada.Animales.E420InterfazParlante;

public class Gato extends Mamifero {
    public static final int APROVECHAMIENTO_COMIDA = 12;

    public Gato(String nombre) {
        super(APROVECHAMIENTO_COMIDA, nombre);
    }

    public Gato(String nombre, int energia) {
        super(APROVECHAMIENTO_COMIDA, nombre, energia);
    }

    public String toString() {
        // Redefinimos este método en Gato para que salga un miau junto a su toString habitual.
        return super.toString() + " ¡Miau!";
    }

    public void habla() {
        String habla;

        if (energia < 30) habla = "miauu....";
        else if (energia <= 70) habla = "miaaauuu";
        else habla = "¡MIAU MIAAAAAU!";

        System.out.println(habla);

        super.habla();
    }
}