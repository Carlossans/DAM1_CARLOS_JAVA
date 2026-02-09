package E920PruebasYoda430;

import java.util.Scanner;

public class E920PruebasYoda430 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();

        while (p != 0) {
            int ultimaFecha = 0; // 'ultimaFecha' guarda el día en que se completó la prueba anterior
            int d, n;

            for (int i = 0; i < p; i++) {
                d = sc.nextInt(); // d: día de la primera sesión disponible
                n = sc.nextInt();// n: cada cuántos días se repite la prueba

                // Si la última prueba terminó en un día igual o posterior a 'd'
                if (ultimaFecha >= d) {
                    /*Calculamos cuántos periodos 'n' deben pasar desde 'd' para superar 'ultimaFecha'. La división entera (ultimaFecha - d) / n nos dice cuántos periodos caben, y sumamos 1 para obtener el siguiente día.*/
                    int numPeriodos = (ultimaFecha - d) / n + 1;

                    // Actualizamos la fecha al nuevo día calculado
                    ultimaFecha = d + (numPeriodos * n);
                } else {
                    // Si 'ultimaFecha' es menor que 'd', Luke puede hacerla en su primera aparición (día d).
                    ultimaFecha = d;
                }
            }

            System.out.println(ultimaFecha);

            // Leemos el valor de 'p' para el siguiente caso de prueba
            // Si es 0, el bucle while terminará en la siguiente evaluación
            p = sc.nextInt();
        }
    }
}