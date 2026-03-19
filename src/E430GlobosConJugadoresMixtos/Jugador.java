package E430GlobosConJugadoresMixtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CLASE ABSTRACTA JUGADOR
 * ======================
 * Esta clase abstracta define la estructura base para todos los jugadores del juego.
 * Se usa 'abstract' porque no queremos crear instancias directas de Jugador,
 * solo de sus subclases (JugadorHumano y JugadorCpu).
 *
 * VENTAJA DE USAR HERENCIA:
 * - Evitamos duplicar código entre JugadorHumano y JugadorCpu
 * - Centralizamos la lógica común (puntuación, aire soplado, cansancio)
 * - Cada subclase solo implementa su forma específica de determinarSoplo()
 */
public abstract class Jugador {

    // ===================================================================
    // CAMPOS PROTECTED (en lugar de private)
    // ===================================================================
    // Usamos 'protected' para que las subclases puedan acceder directamente
    // a estos campos sin necesidad de getters/setters.
    // Esto simplifica el código en las clases hijas.

    /** Nombre del jugador para mostrar en pantalla */
    protected String nombre;

    /** Contador de rondas ganadas por este jugador */
    protected int rondasGanadas;

    /** Contador de rondas perdidas por este jugador */
    protected int rondasPerdidas;

    /**
     * EXTRA: Aire total soplado en toda la partida
     * Se acumula en cada turno para mostrar estadísticas al final
     */
    protected int aireTotalSoplado;

    /**
     * EXTRA: Sistema de cansancio
     * Guarda cuánto sopló el jugador en su turno anterior.
     * Si sopló mucho, en el siguiente turno podrá soplar menos.
     * Ejemplo: Si sopló 10, en la siguiente solo podrá soplar 1 (máx 11 en dos rondas)
     */
    protected int soploAnterior;

    // ===================================================================
    // CONSTANTES DEL JUEGO
    // ===================================================================
    /** Mínimo de aire que se puede soplar en un turno */
    protected static final int MIN_SOPLO = 1;

    /** Máximo de aire que se puede soplar en un turno (sin cansancio) */
    protected static final int MAX_SOPLO = 10;

    /**
     * EXTRA: Máximo de aire que se puede soplar en DOS rondas seguidas.
     * Esto implementa el mecanismo de cansancio: si en una ronda soplas 10,
     * en la siguiente solo podrás soplar 1 (10 + 1 = 11)
     */
    protected static final int MAX_SOPLO_DOS_RONDAS = 11;

    /** Scanner compartido para todas las operaciones de entrada por teclado */
    protected static Scanner scanner = new Scanner(System.in);

    // ===================================================================
    // CONSTRUCTOR
    // ===================================================================
    /**
     * Constructor que inicializa un jugador con su nombre.
     * Los contadores empiezan en 0.
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.rondasGanadas = 0;
        this.rondasPerdidas = 0;
        this.aireTotalSoplado = 0;
        this.soploAnterior = 0; // 0 indica que no ha soplado todavía
    }

    // ===================================================================
    // MÉTODO ABSTRACTO (POLIMORFISMO)
    // ===================================================================
    /**
     * MÉTODO ABSTRACTO: Cada tipo de jugador implementa esto diferente.
     *
     * - JugadorHumano: Pide al usuario por teclado cuánto quiere soplar
     * - JugadorCpu: Calcula aleatoriamente cuánto soplar
     *
     * @return Cantidad de aire que el jugador quiere introducir en el globo
     */
    public abstract int determinarSoplo();

    // ===================================================================
    // MÉTODOS CONCRETOS (COMPARTIDOS POR TODOS LOS JUGADORES)
    // ===================================================================

    /**
     * EXTRA: Gestiona el soplo aplicando el sistema de cansancio.
     * Este método:
     * 1. Calcula el máximo que puede soplar según su cansancio
     * 2. Pide al jugador que determine su soplo (llama al método abstracto)
     * 3. Valida que no exceda el límite por cansancio
     * 4. Registra el soplo para la siguiente ronda
     *
     * @return Cantidad de aire validada y registrada
     */
    public int determinarSoploConCansancio() {
        int maxSoplo = calcularSoplidoMaximo();
        int soplo;

        do {
            soplo = determinarSoplo();
            // Validación: si sopló más de lo permitido por cansancio, avisamos
            if (soplo > maxSoplo) {
                System.out.println("¡Estás cansado! No puedes soplar más de " + maxSoplo + " unidades en este turno.");
            }
        } while (soplo > maxSoplo);

        registrarSoplo(soplo);
        return soplo;
    }

    /**
     * EXTRA: Calcula el máximo de aire que puede soplar según el cansancio.
     * Si no ha soplado antes (soploAnterior = 0), puede soplar el máximo (10).
     * Si ya sopló antes, el máximo es: 11 - lo que sopló anteriormente.
     *
     * Ejemplos:
     * - Anterior: 0  → Máximo: 10 (11 - 0 = 11, pero limitamos a MAX_SOPLO)
     * - Anterior: 10 → Máximo: 1  (11 - 10 = 1)
     * - Anterior: 7  → Máximo: 4  (11 - 7 = 4)
     * - Anterior: 1  → Máximo: 10 (11 - 1 = 10)
     *
     * @return Máximo de unidades de aire permitidas en este turno
     */
    protected int calcularSoplidoMaximo() {
        if (soploAnterior == 0) {
            return MAX_SOPLO; // Primera vez que sopla, no está cansado
        }
        return MAX_SOPLO_DOS_RONDAS - soploAnterior;
    }

    /**
     * EXTRA: Registra el soplo actual para el sistema de cansancio.
     * Guarda cuánto sopló ahora (para la siguiente ronda)
     * y suma al total acumulado de la partida.
     */
    protected void registrarSoplo(int cantidad) {
        this.soploAnterior = cantidad;  // Guardamos para la siguiente ronda
        this.aireTotalSoplado += cantidad; // Sumamos al total de la partida
    }

    /**
     * EXTRA: Reinicia el cansancio al empezar una nueva ronda.
     * Se llama al inicio de cada ronda para que el jugador empiece
     * "descansado" en el primer turno de la nueva ronda.
     */
    public void reiniciarCansancioRonda() {
        this.soploAnterior = 0;
    }

    // ===================================================================
    // MÉTODOS DE PUNTUACIÓN
    // ===================================================================
    /** Incrementa el contador de rondas ganadas */
    public void ganarRonda() {
        rondasGanadas++;
    }

    /** Incrementa el contador de rondas perdidas */
    public void perderRonda() {
        rondasPerdidas++;
    }

    // ===================================================================
    // GETTERS
    // ===================================================================
    public String getNombre() {
        return nombre;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    public int getRondasPerdidas() {
        return rondasPerdidas;
    }

    public int getAireTotalSoplado() {
        return aireTotalSoplado;
    }

    public int getSoploAnterior() {
        return soploAnterior;
    }

    // ===================================================================
    // MÉTODOS ESTÁTICOS DE CONFIGURACIÓN
    // ===================================================================
    /**
     * EXTRA: Permite configurar los jugadores al inicio del juego.
     * Ofrece diferentes modos de juego:
     * - HH: Humano vs Humano
     * - HC: Humano vs CPU
     * - CH: CPU vs Humano
     * - CC: CPU vs CPU
     * - Personalizado: N jugadores humanos y/o CPUs
     *
     * @return Lista de jugadores configurados
     */
    public static List<Jugador> configurarJugadores() {
        List<Jugador> jugadores = new ArrayList<>();

        System.out.println("\n=== CONFIGURACIÓN DE JUGADORES ===");
        System.out.println("Selecciona el modo de juego:");
        System.out.println("1. Humano vs Humano (HH)");
        System.out.println("2. Humano vs CPU (HC)");
        System.out.println("3. CPU vs Humano (CH)");
        System.out.println("4. CPU vs CPU (CC)");
        System.out.println("5. Personalizado (N jugadores)");

        int opcion = leerOpcion(1, 5);

        switch (opcion) {
            case 1 -> {
                // Modo Humano vs Humano: creamos dos JugadorHumano
                String nombre1 = leerString("Nombre del Jugador 1: ");
                String nombre2 = leerString("Nombre del Jugador 2: ");
                jugadores.add(new JugadorHumano(nombre1.isEmpty() ? "Jugador 1" : nombre1));
                jugadores.add(new JugadorHumano(nombre2.isEmpty() ? "Jugador 2" : nombre2));
            }
            case 2 -> {
                // Modo Humano vs CPU: JugadorHumano primero, luego JugadorCpu
                String nombre1 = leerString("Nombre del Jugador Humano: ");
                jugadores.add(new JugadorHumano(nombre1.isEmpty() ? "Humano" : nombre1));
                jugadores.add(new JugadorCpu("CPU"));
            }
            case 3 -> {
                // Modo CPU vs Humano: JugadorCpu primero, luego JugadorHumano
                String nombre2 = leerString("Nombre del Jugador Humano: ");
                jugadores.add(new JugadorCpu("CPU"));
                jugadores.add(new JugadorHumano(nombre2.isEmpty() ? "Humano" : nombre2));
            }
            case 4 -> {
                // Modo CPU vs CPU: dos JugadorCpu
                jugadores.add(new JugadorCpu("CPU-1"));
                jugadores.add(new JugadorCpu("CPU-2"));
            }
            case 5 -> configurarJugadoresPersonalizado(jugadores);
        }

        return jugadores;
    }

    /**
     * EXTRA: Configuración personalizada con N jugadores.
     * Permite al usuario decidir cuántos humanos y cuántas CPUs juegan.
     */
    private static void configurarJugadoresPersonalizado(List<Jugador> jugadores) {
        int numHumanos = leerOpcion("¿Cuántos jugadores humanos? ", 0, 10);
        int numCpus = leerOpcion("¿Cuántos jugadores CPU? ", 0, 10);

        for (int i = 1; i <= numHumanos; i++) {
            String nombre = leerString("Nombre del Humano " + i + ": ");
            jugadores.add(new JugadorHumano(nombre.isEmpty() ? "Humano " + i : nombre));
        }

        for (int i = 1; i <= numCpus; i++) {
            jugadores.add(new JugadorCpu("CPU-" + i));
        }

        // Seguridad: si no hay jugadores, añadimos 2 CPUs por defecto
        if (jugadores.isEmpty()) {
            System.out.println("Debe haber al menos un jugador. Añadiendo 2 CPUs por defecto.");
            jugadores.add(new JugadorCpu("CPU-1"));
            jugadores.add(new JugadorCpu("CPU-2"));
        }
    }

    // ===================================================================
    // MÉTODOS AUXILIARES PARA LECTURA DE DATOS
    // ===================================================================
    private static int leerOpcion(int min, int max) {
        return leerOpcion("", min, max);
    }

    /**
     * Lee una opción numérica validando que esté entre min y max.
     * Maneja excepciones si el usuario introduce texto en lugar de números.
     */
    private static int leerOpcion(String prompt, int min, int max) {
        int numero = min;
        do {
            try {
                if (!prompt.isEmpty()) {
                    System.out.print(prompt);
                    numero = Integer.parseInt(scanner.nextLine());
                } else {
                    System.out.print("Elige una opción: ");
                    numero = Integer.parseInt(scanner.nextLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
            }
        } while (numero < min || numero > max);
        return numero;
    }

    private static String leerString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
