package nose;

import java.util.Scanner;

public class E910EntrenamientoCiclistaProgresivo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int numCasos = teclado.nextInt();

        // Procesamos cada caso de prueba
        for (int i = 0; i < numCasos; i++) {

            // Variables para el cálculo de cada caso de prueba
            int totalKilometros = 0; // Almacena la suma total de kilómetros recorridos (ida + vuelta)
            int distanciaMaxDiaAnterior = 0; // Almacena la distancia máxima alcanzada el día anterior (solo la ida)

            int incremento; // El valor leído del cuentakilómetros

            // Bucle que lee los valores de incremento (el cuentakilómetros) hasta encontrar el 0
            do {
                incremento = teclado.nextInt();

                // Si encontramos el 0, es el final del caso de prueba actual
                if (incremento == 0) {
                    break;
                }

                // 1. Calcular la distancia máxima (de ida) para HOY
                // DistanciaMaxHoy = DistanciaMaxDiaAnterior + Incremento
                int distanciaMaxHoy = distanciaMaxDiaAnterior + incremento;

                // 2. Calcular la distancia total recorrida HOY
                // La distancia total es la ida y la vuelta (2 * distancia de ida)
                int kilometrosHoy = 2 * distanciaMaxHoy;

                // 3. Acumular la distancia total del caso
                totalKilometros = totalKilometros + kilometrosHoy;

                // 4. Preparar para el próximo día: La distancia máxima de hoy
                //    será la distancia máxima del día anterior en la siguiente iteración
                distanciaMaxDiaAnterior = distanciaMaxHoy;
            } while (true);

            // Imprimir el resultado total para el caso de prueba actual
            System.out.println(totalKilometros);
        }
    }
}
