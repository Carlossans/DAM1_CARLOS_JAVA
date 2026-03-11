package b400OOAVANZADA.b40000avanzada.Animales.Figuras;

public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        //super(color);
        this.radio = radio;
    }

    public String toString() {
        //        return getColor()
        //                + "Círculo con radio "
        //                + radio
        //                + ", área "
        //                + calcularArea()
        //                + Figura.RESET;

        return "Circulo - area: " + calcularArea();
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}