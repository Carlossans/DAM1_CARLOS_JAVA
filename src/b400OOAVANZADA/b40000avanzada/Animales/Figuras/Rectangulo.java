package b400OOAVANZADA.b40000avanzada.Animales.Figuras;

public class Rectangulo extends Figura {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        //super(color);
        this.base = base;
        this.altura = altura;
    }

    public String toString() {
        //        return getColor()
        //                + "Rectángulo con base "
        //                + base
        //                + " y altura "
        //                + altura
        //                + ", área "
        //                + calcularArea()
        //                + Figura.RESET;

        return "Rectangulo - area: " + calcularArea();
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calcularArea() {
        return base * altura;
    }
}