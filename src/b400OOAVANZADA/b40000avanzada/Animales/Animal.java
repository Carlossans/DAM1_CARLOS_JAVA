package b400OOAVANZADA.b40000avanzada.Animales;

public abstract class Animal {

    private int energia;

    public abstract String habla();
    //La "Energía" baja al hablar

    public abstract int come(int cantidadComida);
    //La "Energía" sube al comer

    public Animal() {
        energia = 100;
    }

    public Animal(int energia) {
        if (energia > 100) this.energia = 100;
        else if (energia < 0) this.energia = 0;
        else this.energia = energia;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        if (energia > 100) this.energia = 100;
        else if (energia < 0) this.energia = 0;
        else this.energia = energia;
    }
}
