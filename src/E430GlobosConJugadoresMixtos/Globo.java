package E430GlobosConJugadoresMixtos;

/**
 * CLASE GLOBO
 * ===========
 * Representa un globo que los jugadores pueden inflar.
 * Cada globo tiene una capacidad máxima secreta y una cantidad de aire actual.
 * Si el aire actual supera la capacidad máxima, el globo explota.
 *
 * MEJORAS RESPECTO A LA VERSIÓN ANTERIOR:
 * - Representación visual más elaborada (gráfico ASCII)
 * - Métodos separados para mostrar el estado y la explosión
 * - Cálculo proporcional del llenado para la visualización
 */
public class Globo {

    /** Capacidad máxima de aire que aguanta el globo antes de explotar (1-50) */
    private int capacidadMax;

    /** Cantidad actual de aire dentro del globo */
    private int aireActual;

    /**
     * Constructor por defecto: crea un globo con capacidad aleatoria entre 1 y 50.
     * El valor es SECRETO - ni los jugadores humanos ni la CPU lo conocen.
     */
    public Globo() {
        this.capacidadMax = generarNumeroAleatorio(1, 50);
        this.aireActual = 0; // Inicialmente el globo está vacío
    }

    /**
     * Constructor con capacidad específica (útil para pruebas).
     * @param capacidadMax Capacidad máxima del globo
     */
    public Globo(int capacidadMax) {
        this.capacidadMax = capacidadMax;
        this.aireActual = 0;
    }


    /**
     * Genera un número aleatorio entre min y max (ambos inclusive).
     * Fórmula: (int)(Math.random() * (max - min + 1)) + min
     *
     * @param min Valor mínimo
     * @param max Valor máximo
     * @return Número aleatorio en el rango [min, max]
     */
    private int generarNumeroAleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    /**
     * Infla el globo añadiendo una cantidad de aire.
     * Simplemente suma la cantidad al aire actual.
     * La explosión se comprueba DESPUÉS con el método haExplotado().
     *
     * @param cantidad Unidades de aire a añadir
     */
    public void inflar(int cantidad) {
        this.aireActual += cantidad;
    }

    /**
     * Comprueba si el globo ha explotado.
     * El globo explota cuando el aire actual SUPERA la capacidad máxima.
     * Si es igual, no explota (está al límite pero aguanta).
     *
     * @return true si ha explotado, false si no
     */
    public boolean haExplotado() {
        return aireActual > capacidadMax;
    }


    /**
     * MEJORA: Muestra un gráfico ASCII del globo con su estado actual.
     * Dibuja el globo y una barra de progreso que indica visualmente
     * cuánto aire tiene y cuánto le queda.
     */
    public void mostrarGrafico() {
        System.out.println("\n    _______");
        System.out.println("   /       \\");
        System.out.println("  |  " + getRepresentacionVisual() + "  |");
        System.out.println("   \\_______/");
        System.out.println("      | |");
        System.out.println("   " + aireActual + "/" + capacidadMax + " unidades");
    }

    /**
     * Genera una representación visual del llenado del globo.
     * Usa 10 caracteres para representar el estado:
     * - '*' = aire (lleno)
     * - '·' = vacío
     *
     * Ejemplo: "****··" significa 40% lleno (4 de 10 caracteres)
     *
     * @return String de 10 caracteres representando el llenado
     */
    private String getRepresentacionVisual() {
        int totalCaracteres = 10; // Longitud fija de la barra de progreso

        // Calculamos cuántos caracteres deben ser '*' proporcionalmente
        // Si aireActual=25 y capacidadMax=50 → 50% → 5 caracteres llenos
        int caracteresLlenos = (int) ((double) aireActual / capacidadMax * totalCaracteres);

        // Si por algún motivo se pasa, limitamos al máximo
        if (caracteresLlenos > totalCaracteres) {
            caracteresLlenos = totalCaracteres;
        }
        int caracteresVacios = totalCaracteres - caracteresLlenos;

        // Construimos la cadena
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < caracteresLlenos; i++) {
            sb.append("*"); // Caracter de aire
        }
        for (int i = 0; i < caracteresVacios; i++) {
            sb.append("·"); // Caracter de vacío (punto medio)
        }
        return sb.toString();
    }

    /**
     * MEJORA: Muestra una animación/efecto visual de explosión.
     * Dibuja el globo explotando con un efecto ASCII.
     */
    public void mostrarExplosion() {
        System.out.println("\n    **BOOM**");
        System.out.println("   *   |   *");
        System.out.println("  *    |    *");
        System.out.println("   *   |   *");
        System.out.println("    **BOOM**");
        System.out.println("¡EL GLOBO HA EXPLOTADO!");
        System.out.println("Capacidad máxima era: " + capacidadMax + " unidades");
    }


    public int getCapacidadMax() {
        return capacidadMax;
    }

    public int getAireActual() {
        return aireActual;
    }

    /**
     * Representación en texto del globo (útil para depuración).
     */
    public String toString() {
        return "Globo [capacidad=" + capacidadMax + ", aire=" + aireActual + ", explotado=" + haExplotado() + "]";
    }
}
