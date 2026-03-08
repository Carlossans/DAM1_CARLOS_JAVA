package b400OOAVANZADA.b40000avanzada;


public abstract class Figura {

    public static final  String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";

    private String color;

    public Figura(String color) {
        this.color = color;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double calcularArea();

    public String toString() {
        return color + getClass().getSimpleName() + RESET;
    }
}
