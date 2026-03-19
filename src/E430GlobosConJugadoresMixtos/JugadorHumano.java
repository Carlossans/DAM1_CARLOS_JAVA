package E430GlobosConJugadoresMixtos;

import java.util.Scanner;

/**
 * CLASE JUGADORHUMANO (HERENCIA DE JUGADOR)
 * =========================================
 * Esta clase extiende Jugador e implementa el comportamiento específico
 * para un jugador humano (que introduce datos por teclado).
 *
 * HERENCIA:
 * - Hereda todos los campos y métodos de Jugador (nombre, puntuación, cansancio...)
 * - Solo necesita implementar el método abstracto determinarSoplo()
 * - Puede usar directamente los campos 'protected' de la clase padre
 */
public class JugadorHumano extends Jugador {

    /**
     * Scanner privado para leer la entrada del usuario.
     * Cada JugadorHumano tiene su propio Scanner (aunque también
     * podríamos usar el Scanner estático de la clase padre).
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructor que recibe el nombre del jugador.
     * Llama al constructor de la clase padre (super) para inicializar
     * los campos heredados.
     */
    public JugadorHumano(String nombre) {
        super(nombre);
    }

    /**
     * IMPLEMENTACIÓN DEL MÉTODO ABSTRACTO determinarSoplo()
     * =====================================================
     *
     * PARA QUÉ SIRVE:
     * Este método implementa cómo un jugador humano decide cuánto aire
     * quiere soplar. Como es un humano, le preguntamos por teclado.
     *
     * QUÉ HACE:
     * 1. Calcula el máximo que puede soplar según el cansancio (heredado de Jugador)
     * 2. Muestra información útil al jugador (aire total, cansancio si aplica)
     * 3. Pide al usuario que introduzca un número válido
     * 4. Valida que esté entre MIN_SOPLO y maxSoplo
     * 5. Devuelve la cantidad elegida
     *
     * @return Cantidad de aire que el humano quiere soplar (validada)
     */
    @Override
    public int determinarSoplo() {
        // Calculamos el máximo permitido según el cansancio anterior
        // Este método está definido en Jugador (clase padre)
        int maxSoplo = calcularSoplidoMaximo();

        // Mostramos información del turno
        System.out.println("\n--- Turno de " + nombre + " ---");
        System.out.println("Aire total soplado en la partida: " + aireTotalSoplado);

        // Si ya sopló antes, mostramos información del cansancio
        // soploAnterior es un campo 'protected' heredado de Jugador
        if (soploAnterior > 0) {
            System.out.println("Soplaste " + soploAnterior + " en tu turno anterior.");
            System.out.println("Estás cansado: máximo puedes soplar " + maxSoplo + " unidades.");
        }

        // Bucle de validación: pedimos hasta que introduzca un número válido
        int soplo = 0;
        do {
            try {
                // Mostramos el rango permitido
                System.out.print("¿Cuánto aire quieres soplar (" + MIN_SOPLO + "-" + maxSoplo + ")? ");
                soplo = Integer.parseInt(scanner.nextLine());

                // Validaciones
                if (soplo < MIN_SOPLO) {
                    System.out.println("Debes soplar al menos " + MIN_SOPLO + " unidad.");
                } else if (soplo > maxSoplo) {
                    System.out.println("¡Estás demasiado cansado! Máximo puedes soplar " + maxSoplo + " unidades.");
                }
            } catch (NumberFormatException e) {
                // Si introduce texto en lugar de número, capturamos la excepción
                System.out.println("Por favor, introduce un número válido.");
            }
        } while (soplo < MIN_SOPLO || soplo > maxSoplo);

        return soplo;
    }
}
