package E916VerificacionEntradas711;

import java.util.Scanner;

public class E916VerificacionEntradas711 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer el número de casos de prueba
        int num_casos = Integer.parseInt(sc.nextLine().trim());

        // Procesar cada caso
        while (num_casos-- > 0) {
            // Leer el número de la entrada
            String numero = sc.nextLine().trim();

            // Arrays para almacenar el menor dígito a la derecha y el mayor a la izquierda de cada posición
            int[] menores = new int[numero.length()];
            int[] mayores = new int[numero.length()];

            // Inicializar valores extremos para comparaciones
            int minimo = 10;  // Valor mayor que cualquier dígito
            int maximo = -1;  // Valor menor que cualquier dígito

            // Recorrido de izquierda a derecha: guardar el mayor dígito encontrado hasta ahora
            for (int i = 0; i < numero.length(); i++) {
                mayores[i] = maximo;  // Guardar el mayor dígito a la izquierda
                maximo = Math.max(maximo, numero.charAt(i) - '0');  // Actualizar el máximo
            }

            // Recorrido de derecha a izquierda: guardar el menor dígito encontrado hasta ahora
            for (int i = numero.length() - 1; i >= 0; i--) {
                menores[i] = minimo;  // Guardar el menor dígito a la derecha
                minimo = Math.min(minimo, numero.charAt(i) - '0');  // Actualizar el mínimo
            }

            int codigo = 0;  // Código de verificación a calcular
            boolean impar = true;  // Indica si estamos en posición impar (empieza en true para la primera posición)
            boolean noCeroIzquierda = false;  // Indica si ya hemos encontrado un dígito distinto de 0

            // Calcular el código de verificación
            for (int i = 0; i < numero.length(); i++) {
                // Ignorar ceros a la izquierda del número
                if (numero.charAt(i) != '0' || noCeroIzquierda) {
                    if (impar) {
                        // Posición impar: dígito * 3 + menor dígito a su derecha
                        codigo += (numero.charAt(i) - '0') * 3 + menores[i];
                    } else {
                        // Posición par: dígito * 2 + mayor dígito a su izquierda
                        codigo += (numero.charAt(i) - '0') * 2 + mayores[i];
                    }
                    noCeroIzquierda = true;  // Ya no hay ceros a la izquierda
                }
                impar = !impar;  // Alternar entre posición impar y par
            }

            // Imprimir el código de verificación
            System.out.println(codigo);
        }
    }
}
