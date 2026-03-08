package b400OOAVANZADA.b40000avanzada;

public class Cuadrado extends Rectangulo {
    public Cuadrado(double lado, String color) {
        super(lado, lado, color);
    }

    public String toString() {
        return super.toString() + " lado=" + base;
    }
}