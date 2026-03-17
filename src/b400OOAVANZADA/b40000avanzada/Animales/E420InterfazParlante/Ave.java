package b400OOAVANZADA.b40000avanzada.Animales.E420InterfazParlante;

public abstract class Ave extends Animal {
    public static final int GASTO_POR_HABLAR = 2;

    public Ave(int aprovechamientoComida, String nombre) {
        super(aprovechamientoComida, GASTO_POR_HABLAR, nombre);
    }

    public Ave(int aprovechamientoComida, String nombre, int energia) {
        super(aprovechamientoComida, GASTO_POR_HABLAR, nombre, energia);
    }
}