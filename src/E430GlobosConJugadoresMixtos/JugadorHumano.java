package E430GlobosConJugadoresMixtos;

import java.util.Scanner;

public class JugadorHumano extends Jugador {
    private Scanner scanner = new Scanner(System.in);

    public JugadorHumano(String nombre) {
        super(nombre);
    }

    @Override
    public int determinarSoplo() {
        int maxSoplo = calcularSoplidoMaximo();

        System.out.println("\n--- Turno de " + nombre + " ---");
        System.out.println("Aire total soplado en la partida: " + aireTotalSoplado);
        if (soploAnterior > 0) {
            System.out.println("Soplaste " + soploAnterior + " en tu turno anterior.");
            System.out.println("Estás cansado: máximo puedes soplar " + maxSoplo + " unidades.");
        }

        int soplo = 0;
        do {
            try {
                System.out.print("¿Cuánto aire quieres soplar (" + MIN_SOPLO + "-" + maxSoplo + ")? ");
                soplo = Integer.parseInt(scanner.nextLine());

                if (soplo < MIN_SOPLO) {
                    System.out.println("Debes soplar al menos " + MIN_SOPLO + " unidad.");
                } else if (soplo > maxSoplo) {
                    System.out.println("¡Estás demasiado cansado! Máximo puedes soplar " + maxSoplo + " unidades.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
            }
        } while (soplo < MIN_SOPLO || soplo > maxSoplo);

        return soplo;
    }
}
