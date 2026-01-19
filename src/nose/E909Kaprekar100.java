package nose;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E909Kaprekar100 {
    private static int asc(int numero) {
        int[] digitos = new int[4];
        for (int i = 3; i >= 0; i--) {
            digitos[i] = numero % 10;
            numero /= 10;
        }
        java.util.Arrays.sort(digitos);
        return digitos[0]*1000 + digitos[1]*100 + digitos[2]*10 + digitos[3];
    }

    private static int desc(int numero) {
        int[] digitos = new int[4];
        for (int i = 3; i >= 0; i--) {
            digitos[i] = numero % 10;
            numero /= 10;
        }
        java.util.Arrays.sort(digitos);
        return digitos[3]*1000 + digitos[2]*100 + digitos[1]*10 + digitos[0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int casos = Integer.parseInt(br.readLine().trim());

        StringBuilder salida = new StringBuilder();

        for (int i = 0; i < casos; i++) {
            int num = Integer.parseInt(br.readLine().trim());

            if (num == 6174) {
                salida.append("0\n");
                continue;
            }

            int d1 = num / 1000;
            int d2 = (num / 100) % 10;
            int d3 = (num / 10) % 10;
            int d4 = num % 10;
            if (d1 == d2 && d2 == d3 && d3 == d4) {
                salida.append("8\n");
                continue;
            }

            int pasos = 0;
            int actual = num;

            while (actual != 6174) {
                int mayor = desc(actual);
                int menor = asc(actual);
                actual = mayor - menor;
                pasos++;
            }
            salida.append(pasos).append('\n');
        }
        System.out.print(salida);
    }
}
