package b400OOAVANZADA.b40000avanzada.Animales;

public class Perro extends Mamifero{

    public Perro() {
        super();
    }

    public Perro(int energia) {
        super(energia);
    }

    public String habla() {
        String sonido;

        if(getEnergia() < 30) sonido = "guau guau";
        if(getEnergia() >= 30 && getEnergia() < 70) sonido = "guau";
        else sonido = "!!GUAU!!";

        System.out.println(sonido);
        return super.habla();
    }

    public int come(int cantidadComida) {
        setEnergia(getEnergia() + cantidadComida * 7);
        return getEnergia();
    }
}
