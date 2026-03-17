package b400OOAVANZADA.b40000avanzada.Animales.E420InterfazParlante;

public abstract class Mamifero extends Animal {
    public static final int GASTO_POR_HABLAR = 3;

    public Mamifero(int aprovechamientoComida, String nombre) {
        super(GASTO_POR_HABLAR, aprovechamientoComida, nombre);
    }

    public Mamifero(int aprovechamientoComida, String nombre, int energia) {
        super(GASTO_POR_HABLAR, aprovechamientoComida, nombre, energia);
    }
}