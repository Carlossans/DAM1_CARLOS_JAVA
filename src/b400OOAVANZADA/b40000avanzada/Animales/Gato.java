package b400OOAVANZADA.b40000avanzada.Animales;

public class Gato extends Mamifero{

    public Gato() {
        super();
    }

    public Gato(int energia) {
        super(energia);
    }

    public String habla() {
        String sonido;
        if (getEnergia() < 30) sonido = "miauuuuuu...";
        else if (getEnergia() >= 30 && getEnergia() < 70) sonido = "miau";
        else sonido = "¡¡MIAU!!";

        System.out.println(sonido);
        return super.habla();
    }

    public int come(int cantidadComida) {
        setEnergia(getEnergia() + cantidadComida * 12);
        return getEnergia();
    }
}