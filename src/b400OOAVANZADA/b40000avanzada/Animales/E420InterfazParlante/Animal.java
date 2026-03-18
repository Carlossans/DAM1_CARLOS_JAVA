package b400OOAVANZADA.b40000avanzada.Animales.E420InterfazParlante;

public abstract class Animal {
    public static final int ENERGIA_POR_DEFECTO = 100;
    public static final int ENERGIA_MIN = 0;
    public static final int ENERGIA_MAX = 100;

    protected int aprovechamientoComida;
    protected int gastoPorHablar;
    protected String nombre;
    protected int energia;

    public Animal(int aprovechamientoComida, int gastoPorHablar, String nombre) {
        this(aprovechamientoComida, gastoPorHablar, nombre, ENERGIA_POR_DEFECTO);
    }

    public Animal(int aprovechamientoComida, int gastoPorHablar, String nombre, int energia) {
        this.aprovechamientoComida = aprovechamientoComida;
        this.gastoPorHablar = gastoPorHablar;
        this.nombre = nombre;
        this.energia = energia;
    }

    public String toString() {
        return this.getClass().getSimpleName() + " " + nombre;
    }

    public void come(int cantidad) {
        energia = energia + (cantidad * aprovechamientoComida) ;

        if (energia > ENERGIA_MAX) energia = ENERGIA_MAX;
    }

    protected void gastarEnergiaPorHablar() {
        energia = energia - gastoPorHablar;

        if (energia < ENERGIA_MIN) energia = ENERGIA_MIN;
    }
}