package programame;

import java.util.Scanner;

public class PiramidesCleopatra {
    public static int calcularDistancia(int anno1, int anno2) {
        if ((anno1 > 0 && anno2 > 0) || (anno1 < 0 && anno2 < 0)) {
            return Math.abs(anno1 - anno2);
        } else {
            return Math.abs(anno1 - anno2) - 1;
        }
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int casos = teclado.nextInt();

        for (int i = 0; i < casos; i++) {

            int A = teclado.nextInt();
            int B = teclado.nextInt();
            int C = teclado.nextInt();

            int distanciaAB = calcularDistancia(A, B);

            int distanciaCB = calcularDistancia(C, B);

            if (distanciaAB < distanciaCB) {
                System.out.println(A);
            } else if (distanciaCB < distanciaAB) {
                System.out.println(C);
            } else {
                System.out.println("EMPATE");
            }
        }
    }
}
