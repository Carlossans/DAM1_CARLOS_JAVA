package b400OOAVANZADA.b40000avanzada.Animales.E420InterfazParlante;

public class Conejo extends Mamifero {
    public static final int APROVECHAMIENTO_COMIDA = 8;

    public Conejo(String nombre) {
        super(APROVECHAMIENTO_COMIDA, nombre);
    }

    public Conejo(String nombre, int energia) {
        super(APROVECHAMIENTO_COMIDA, nombre, energia);
    }
}
