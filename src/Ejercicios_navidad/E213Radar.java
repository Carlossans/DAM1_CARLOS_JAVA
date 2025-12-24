package Ejercicios_navidad;

import java.util.Scanner;

public class E213Radar {
    private static void comprobarVelocidad(int longitudArrays, int limite, int[] segundo, int[] distancia) {
        int contador = 1;
        for (int i = 0; i < longitudArrays && contador < longitudArrays; i++) {
            if (distancia[i + 1] - distancia[i] == (segundo[i + 1] - segundo[i]) * limite) {
                System.out.println("\nAVISO");
                contador++;
            } else if (distancia[i + 1] - distancia[i] >= (segundo[i + 1] - segundo[i]) * limite) {
                System.out.println("\nMULTA");
                contador++;
            } else {
                System.out.println("\nTODO BIEN");
                contador++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while (true) {
            System.out.println("\nIntroduce el límite de velocidad: \n");
            int limite = teclado.nextInt();
            if (limite == 0) {
                System.out.println("\nADIOSS");
                break;
            }
            System.out.println("\nIntroduce la cantidad de casos de prueba: \n");
            int casosPrueba = teclado.nextInt();

            int[] segundo = new int[casosPrueba];
            int[] distanciaRecorrida = new int[casosPrueba];
            int longitudArrays = segundo.length;

            for (int i = 0; i < casosPrueba; i++) {
                segundo[i] = teclado.nextInt();
                distanciaRecorrida[i] = teclado.nextInt();
            }

            comprobarVelocidad(longitudArrays, limite, segundo, distanciaRecorrida);
        }
    }
}
