package b400OOAVANZADA.b40000avanzada;

public class Principal {
    static void main(String[] args) {
        //Figura f1 = new Figura(); // Error porque es abstracta y no se puede crear un objecto "Figura" por el "abstracta".
        Figura f2 = new Circulo(7.59);
        Figura f3 = new Rectangulo(3.45, 8.91);
        //Figura f4 = new Cuadrado(6.72);
        Circulo c1 = new Circulo(5.55);
        //Circulo c2 = new Figura(); // Error porque es abstracta y no se puede crear un objecto "Figura" por el "abstract".
        Rectangulo r1 = new Rectangulo(3.01, 8.53 );
        Cuadrado q1 = new Cuadrado(4.15);

        System.out.println(f2.calcularArea());
        System.out.println(c1.calcularArea());
        System.out.println(f3.calcularArea());
        System.out.println(r1.calcularArea());

        Figura[] figuras = new Figura[4];
        figuras[0] = f2;
        figuras[1] = c1;
        figuras[2] = f3;
        figuras[3] = r1;

        for (Figura f : figuras) {
            System.out.println(f.calcularArea());
        }
    }
}
