package E928Avituallamiento122;
import java.util.Scanner;

public class E928Avituallamiento122 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        while (true) {

            int alturaAnterior = entrada.nextInt();

            if (alturaAnterior == -1) {
                break;
            }

            int km = 0;

            int mejorInicio = -1;
            int mejorLongitud = 0;

            int inicioActual = 0;
            int longitudActual = 0;

            while (true) {

                int alturaActual = entrada.nextInt();

                if (alturaActual == -1) {
                    break;
                }

                if (alturaActual == alturaAnterior) {
                    if (longitudActual == 0) {
                        inicioActual = km;
                    }
                    longitudActual++;
                } else {
                    if (longitudActual > mejorLongitud) {
                        mejorLongitud = longitudActual;
                        mejorInicio = inicioActual;
                    }
                    longitudActual = 0;
                }

                alturaAnterior = alturaActual;
                km++;
            }

            if (longitudActual > mejorLongitud) {
                mejorLongitud = longitudActual;
                mejorInicio = inicioActual;
            }

            if (mejorLongitud == 0) {
                System.out.println("HOY NO COMEN");
            } else {
                System.out.println(mejorInicio + " " + mejorLongitud);
            }
        }
    }
}
