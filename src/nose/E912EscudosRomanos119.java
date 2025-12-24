package nose;

import java.util.Scanner;

public class E912EscudosRomanos119 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        while (true) {
            int legionarios = teclado.nextInt();
            if (legionarios == 0) break;

            int escudos = 0;

            while (legionarios > 0) {
                int ladocuadrado = (int) Math.sqrt(legionarios); // casteo la expresión a int para que no me dé decimales.
                legionarios = legionarios - (ladocuadrado * ladocuadrado);
                escudos = (int) (escudos + (Math.pow(ladocuadrado, 2) + (4 * ladocuadrado))); // casteo la expresión a int para que no me dé decimales.
            }

            System.out.println(escudos);
        }
    }
}