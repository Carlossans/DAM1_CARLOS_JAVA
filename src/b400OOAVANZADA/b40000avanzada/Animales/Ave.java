package b400OOAVANZADA.b40000avanzada.Animales;

public class Ave extends Animal {

    public Ave() {
        super();
    }

    public Ave(int energia) {
        super(energia);
    }

    public String habla() {
        setEnergia(getEnergia() - 2);
        return "";
    }

    public int come(int cantidadComida) {
        return getEnergia();
    }
}
