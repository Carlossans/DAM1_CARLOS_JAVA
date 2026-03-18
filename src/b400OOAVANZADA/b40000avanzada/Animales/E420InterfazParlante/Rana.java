package b400OOAVANZADA.b40000avanzada.Animales.E420InterfazParlante;

public class Rana extends Anfibio implements Parlante {
    public static final int APROVECHAMIENTO_COMIDA = 6;

    public Rana(String nombre) {
        super(APROVECHAMIENTO_COMIDA, nombre);
    }

    public Rana(String nombre, int energia) {
        super(APROVECHAMIENTO_COMIDA, nombre, energia);
    }

    public void habla() {
        String habla;

        if (energia < 30) habla = "crooc....";
        else if (energia <= 70) habla = "croaaac";
        else habla = "¡CROO CROAAAAC!";

        System.out.println(habla);

        gastarEnergiaPorHablar();
    }
}