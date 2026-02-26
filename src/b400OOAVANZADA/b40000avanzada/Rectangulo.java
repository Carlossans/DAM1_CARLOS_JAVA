package b400OOAVANZADA.b40000avanzada;

public class Rectangulo extends Figura{
    protected double base, altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        return base * altura;
    }
}
