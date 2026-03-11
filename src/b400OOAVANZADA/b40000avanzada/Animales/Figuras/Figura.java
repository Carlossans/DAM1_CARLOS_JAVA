package b400OOAVANZADA.b40000avanzada.Animales.Figuras;

public abstract class Figura implements Comparable<Figura> {
    public abstract double calcularArea();

    public int compareTo(Figura otro) {
        return Double.compare(this.calcularArea(), otro.calcularArea());
//        double diferencia = this.calcularArea() - otro.calcularArea();
//        if (diferencia < 0) return - 1;
    }
}