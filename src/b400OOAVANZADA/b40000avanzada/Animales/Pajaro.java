package b400OOAVANZADA.b40000avanzada.Animales;

public class Pajaro extends Ave{

    public Pajaro() {
        super();
    }

    public Pajaro(int energia) {
        super(energia);
    }

    public String habla() {
        String sonido;
        if (getEnergia() < 30) sonido = "pío pío";
        else if (getEnergia() >= 30 && getEnergia() < 70) sonido = "pío";
        else sonido = "!!PÍO!!";
        System.out.println(sonido);
        return super.habla();
    }

    public int come(int cantidadComida) {
        setEnergia(getEnergia() + cantidadComida * 5);
        return getEnergia();
    }
}
