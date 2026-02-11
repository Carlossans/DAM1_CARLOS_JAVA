package E325Frase;

public class Principal {
    public static void main(String[] args) {

        Frase frase1 = new Frase();
        System.out.println("Frase vacía: '" + frase1 + "'");
        System.out.println("Longitud: " + frase1.longitud());


        Frase frase2 = new Frase("Hola mundo");

        System.out.println("\nFrase con constructor String: '" + frase2 + "'");
        System.out.println("Longitud: " + frase2.longitud());
        System.out.println("Carácter en posición 0: " + frase2.caracterEn(0));
        System.out.println("Carácter en posición 5: " + frase2.caracterEn(5));


        frase1.anexar("Primera");
        System.out.println("\nFrase1 después de anexar 'Primera': '" + frase1 + "'");
        frase1.anexar("palabra");
        System.out.println("Frase1 después de anexar 'palabra': '" + frase1 + "'");


        frase2.recortar(3);
        System.out.println("\nFrase2 después de recortar 3 caracteres: '" + frase2 + "'");


        Frase frase3 = frase2.clone();
        System.out.println("\nFrase3: '" + frase3 + "'");
        System.out.println("¿Son iguales frase2 y frase3? " + frase2.equals(frase3));


        Frase frase4 = new Frase("Hola mun");
        System.out.println("\nFrase4: '" + frase4 + "'");
        System.out.println("¿Son iguales frase2 y frase4? " + frase2.equals(frase4));


        Frase frase5 = new Frase(3, "hola");
        System.out.println("\nFrase con 3 repeticiones de 'hola': '" + frase5 + "'");
        System.out.println("Longitud: " + frase5.longitud());


        frase5.recortar(2);
        System.out.println("\nFrase5 después de recortar 2: '" + frase5 + "'");


        frase5.recortar(20);
        System.out.println("Frase5 después de recortar 20: '" + frase5 + "'");


        Frase frase6 = new Frase();
        frase6.anexar("SinEspacioAlPrincipio");
        System.out.println("\nFrase6: '" + frase6 + "'");
    }
}
