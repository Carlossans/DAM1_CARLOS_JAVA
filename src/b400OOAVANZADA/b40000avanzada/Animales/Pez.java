package b400OOAVANZADA.b40000avanzada.Animales;

public class Pez extends Animal {

    public Pez() {
        super();
    }

    public Pez(int energia) {
        super(energia);
    }

    public String habla() {
        String sonido;
        if (getEnergia() < 30) sonido = "glu glu";
        else if (getEnergia() >= 30 && getEnergia() < 70) sonido = "glu";
        else sonido = "¡¡GLU GLU!!";

        System.out.println(sonido);
        setEnergia(getEnergia() - 3);
        return sonido;
    }

    public int come(int cantidadComida) {
        setEnergia(getEnergia() + cantidadComida * 2);
        return getEnergia();
    }
}