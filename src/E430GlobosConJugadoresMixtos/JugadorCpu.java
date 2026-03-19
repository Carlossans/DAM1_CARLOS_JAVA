package E430GlobosConJugadoresMixtos;

/**
 * CLASE JUGADORCPU (HERENCIA DE JUGADOR)
 * =====================================
 * Esta clase extiende Jugador e implementa el comportamiento específico
 * para un jugador controlado por la máquina (CPU).
 *
 * HERENCIA:
 * - Hereda todos los campos y métodos de Jugador (nombre, puntuación, cansancio...)
 * - Solo necesita implementar el método abstracto determinarSoplo()
 * - La CPU decide aleatoriamente cuánto soplar (simulando una "IA" simple)
 *
 * DIFERENCIA CON JUGADORHUMANO:
 * - JugadorHumano: Pide entrada por teclado al usuario
 * - JugadorCpu: Genera un número aleatorio usando Math.random()
 */
public class JugadorCpu extends Jugador {

    /**
     * Constructor que recibe el nombre del jugador CPU.
     * Llama al constructor de la clase padre (super) para inicializar
     * los campos heredados.
     */
    public JugadorCpu(String nombre) {
        super(nombre);
    }

    /**
     * IMPLEMENTACIÓN DEL MÉTODO ABSTRACTO determinarSoplo()
     * =====================================================
     *
     * PARA QUÉ SIRVE:
     * Este método implementa cómo la CPU decide cuánto aire quiere soplar.
     * Como es una máquina, calculamos un número aleatorio.
     *
     * QUÉ HACE:
     * 1. Calcula el máximo que puede soplar según el cansancio (heredado de Jugador)
     * 2. Genera un número aleatorio entre MIN_SOPLO y maxSoplo
     * 3. Muestra información del turno (para que el humano vea qué hace la CPU)
     * 4. Devuelve la cantidad aleatoria generada
     *
     * NOTA: La CPU no "hace trampa" - no conoce la capacidad del globo,
     * solo sopla aleatoriamente como haría un jugador humano.
     *
     * @return Cantidad de aire aleatoria que la CPU soplará
     */
    @Override
    public int determinarSoplo() {
        // Calculamos el máximo permitido según el cansancio anterior
        // Este método está definido en Jugador (clase padre)
        int maxSoplo = calcularSoplidoMaximo();

        // Generamos un número aleatorio entre MIN_SOPLO y maxSoplo
        // Fórmula: (int)(Math.random() * (max - min + 1)) + min
        // Ejemplo: Si maxSoplo=10 y MIN_SOPLO=1 → número entre 1 y 10
        int soplo = (int) (Math.random() * (maxSoplo - MIN_SOPLO + 1)) + MIN_SOPLO;

        // Mostramos información del turno para que el humano vea qué hace la CPU
        System.out.println("\n--- Turno de " + nombre + " (CPU) ---");
        System.out.println("Aire total soplado en la partida: " + aireTotalSoplado);

        // Si ya sopló antes, mostramos información del cansancio
        // soploAnterior es un campo 'protected' heredado de Jugador
        if (soploAnterior > 0) {
            System.out.println("Sopló " + soploAnterior + " en su turno anterior.");
            System.out.println("Está cansado: máximo puede soplar " + maxSoplo + " unidades.");
        }

        // Mostramos la decisión de la CPU
        System.out.println(nombre + " decide soplar " + soplo + " unidades de aire.");

        return soplo;
    }
}
