package E928Avituallamiento122;

import java.util.Scanner;

public class E928Avituallamiento122 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String linea = sc.nextLine().trim();

            // Si la línea está vacía, la saltamos
            if (linea.isEmpty()) {
                continue;
            }

            // Parseamos las alturas
            String[] partes = linea.split("\\s+");
            int[] alturas = new int[partes.length];

            for (int i = 0; i < partes.length; i++) {
                alturas[i] = Integer.parseInt(partes[i]);
            }

            // Buscamos la zona llana más larga
            int mejorInicio = -1;
            int mejorLongitud = 0;

            int i = 0;
            while (i < alturas.length - 1) {
                // Verificar si hay una zona llana que comienza en i
                int j = i;
                while (j < alturas.length - 1 && alturas[j] == alturas[j + 1]) {
                    j++;
                }

                // Calcular la longitud de la zona llana
                int longitud = j - i + 1;

                // Si encontramos una zona llana más larga, la guardamos
                if (j > i && longitud > mejorLongitud) {
                    mejorInicio = i;
                    mejorLongitud = longitud;
                }

                // Avanzar al siguiente punto después de la zona llana
                if (j > i) {
                    i = j + 1;
                } else {
                    i++;
                }
            }

            // Imprimir resultado
            if (mejorInicio == -1) {
                System.out.println("HOY NO COMEN");
            } else {
                System.out.println(mejorInicio + " " + mejorLongitud);
            }
        }
    }
}


