package b300basicaE300ContadorBasico;

public class Principal {
    public static void main(String[] args) {
//        Contador c1 = new Contador();
        Contador c2 = new Contador(77);
        Contador c3 = new Contador(77, 5);
        Contador c4 = new Contador(77, 5, true);
//        Contador c5 = new Contador(77, true);

        System.out.println(c3);
        System.out.println(c2);
        System.out.println(c4);

    }
}
