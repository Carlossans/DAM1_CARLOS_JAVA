package E920PruebasYoda430;

import java.util.Scanner;

public class E920PruebasYoda430 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();

        while (p != 0) {
            int ultimaFecha = 0;
            int d;
            int n;

            for (int i = 0; i < p; i++) {
                d = sc.nextInt();
                n = sc.nextInt();

                if (ultimaFecha >= d) {
                    int numPeriodos = (ultimaFecha - d) / n + 1;

                    ultimaFecha = d + (numPeriodos * n);
                } else {
                    ultimaFecha = d;
                }
            }

            System.out.println(ultimaFecha);

            p = sc.nextInt();
        }
    }
}