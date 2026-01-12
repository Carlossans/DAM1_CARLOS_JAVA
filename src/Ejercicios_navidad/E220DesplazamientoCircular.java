package Ejercicios_navidad;

import java.util.Arrays;
import java.util.Scanner;

public class E220DesplazamientoCircular {
    private static final int[] arrayLiteral = {1, 2, 3, 4, 5, 6, 7, 8};
    private static void mostrarEstadoArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
    private static void desplazarIzq(int saltos) {
        for (int s = 0; s < saltos; s++) {
            int primero = arrayLiteral[0];
            for (int i = 0; i < arrayLiteral.length - 1; i++) {
                arrayLiteral[i] = arrayLiteral[i + 1];
            }
            arrayLiteral[arrayLiteral.length - 1] = primero;
        }
        mostrarEstadoArray(arrayLiteral);
    }

    private static void desplazarDch(int saltos) {
        for (int s = 0; s < saltos; s++) {
            int ultimo = arrayLiteral[arrayLiteral.length - 1];
            for (int i = arrayLiteral.length - 1; i > 0; i--) {
                arrayLiteral[i] = arrayLiteral[i - 1];
            }
            arrayLiteral[0] = ultimo;
        }
        mostrarEstadoArray(arrayLiteral);
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("\nEstado actual del array: ");
        mostrarEstadoArray(arrayLiteral);
        char direccion;
        do {
            System.out.println("\n¿Hacia donde quieres hacer el desplazamiento? i [izquierda] | d [derecha] | x [salir]");
            direccion = teclado.next().toLowerCase().charAt(0);

            if (direccion == 'i' || direccion == 'd') {
                int saltos;

                do {
                    System.out.println("\nIntroduce la cantidad de saltos que quieres hacer: ");
                    saltos = Integer.parseInt(teclado.next());
                } while (saltos < 1);

                saltos = saltos % arrayLiteral.length;

                if (direccion == 'i') {
                    desplazarIzq(saltos);
                } else {
                    desplazarDch(saltos);
                }
            }
        } while (direccion != 'x');
    }
}
