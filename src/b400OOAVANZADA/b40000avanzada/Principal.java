package b400OOAVANZADA.b40000avanzada;

public class Principal {
    public static void main(String[] args) {

        Figura f2 = new Circulo(7.59, Figura.AZUL);
        Figura f3 = new Rectangulo(3.45, 8.91, Figura.VERDE);
        Circulo c1 = new Circulo(5.55, Figura.ROJO);
        Rectangulo r1 = new Rectangulo(3.01, 8.53, Figura.AMARILLO);
        Cuadrado q1 = new Cuadrado(4.15, Figura.AZUL);

        Figura[] figuras = new Figura[5];
        figuras[0] = f2;
        figuras[1] = c1;
        figuras[2] = f3;
        figuras[3] = r1;
        figuras[4] = q1;
        double areaTotal = 0;

        System.out.println("Áreas de las figuras:\n");

        for (Figura f : figuras) {
            double area = f.calcularArea();
            System.out.println(f + " -> Área: " + area);
            areaTotal = areaTotal + area;
        }

        System.out.println("\nLa suma de las áreas de todas las figuras es: " + areaTotal);

        System.out.println("\nRadio del círculo c1: " + c1.getRadio());
        c1.setRadio(10.0);
        System.out.println("Nuevo área de c1: " + c1.calcularArea());

        System.out.println("\nColor original de c1: " + c1.getColor() + "Color de muestra" + Figura.RESET);
        c1.setColor(Figura.VERDE);
        System.out.println("Color cambiado de c1: " + c1);
    }
}