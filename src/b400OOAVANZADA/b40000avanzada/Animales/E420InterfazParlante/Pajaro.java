package b400OOAVANZADA.b40000avanzada.Animales.E420InterfazParlante;

public class Pajaro extends Ave implements Parlante {
    public static final int APROVECHAMIENTO_COMIDA = 5;

    public Pajaro(String nombre) {
        super(APROVECHAMIENTO_COMIDA, nombre);
    }

    public Pajaro(String nombre, int energia) {
        super(APROVECHAMIENTO_COMIDA, nombre, energia);
    }

    public void habla() {
        String habla;

        if (energia < 30) habla = "piiiio....";
        else if (energia <= 70) habla = "pio pio";
        else habla = "¡PIIIO PIOOOOOOOO!";

        System.out.println(habla);

        gastarEnergiaPorHablar();
    }
}