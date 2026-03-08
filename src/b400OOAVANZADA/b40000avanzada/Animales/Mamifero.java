package b400OOAVANZADA.b40000avanzada.Animales;

public class Mamifero extends Animal{

    public Mamifero() {
        super();
    }

    public Mamifero(int energia) {
        super(energia);
    }

    public String habla() {
        setEnergia(getEnergia() - 5);
        return "";
    }

    public int come(int cantidadComida) {
        return getEnergia();
    }
}
