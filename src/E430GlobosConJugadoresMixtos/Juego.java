package E430GlobosConJugadoresMixtos;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    /**
     * MEJORA: Lista de jugadores en lugar de variables individuales.
     * Esto permite tener 2, 3, 4... N jugadores sin cambiar el código.
     * Usamos polimorfismo: la lista contiene objetos Jugador, que pueden
     * ser JugadorHumano o JugadorCpu indistintamente.
     */
    private List<Jugador> jugadores;

    /** Número de rondas que un jugador debe ganar para ganar la partida */
    private int rondasParaGanar;

    /** Contador de rondas jugadas */
    private int rondasJugadas;

    /** Constante: número total de rondas en una partida */
    private static final int RONDAS_TOTALES = 5;
    /**
     * Constructor: inicializa el juego con valores por defecto.
     * La configuración de jugadores se hace después mediante configurar().
     */
    public Juego() {
        this.jugadores = new ArrayList<>();
        // Calculamos cuántas rondas hay que ganar: mayoría simple
        // Para 5 rondas: (5/2) + 1 = 2 + 1 = 3 rondas para ganar
        this.rondasParaGanar = (RONDAS_TOTALES / 2) + 1;
        this.rondasJugadas = 0;
    }

    /**
     * Configura los jugadores llamando al método estático de Jugador.
     * Esto permite elegir entre HH, HC, CH, CC o modo personalizado.
     */
    public void configurar() {
        jugadores = Jugador.configurarJugadores();
    }

    /**
     * Método principal que inicia y controla el flujo del juego.
     * Se encarga de:
     * 1. Mostrar la bienvenida
     * 2. Jugar rondas hasta que haya un ganador
     * 3. Mostrar el resultado final
     */
    public void empezar() {
        mostrarBienvenida();

        // Bucle principal: jugar rondas mientras no haya ganador y queden rondas
        while (!hayGanadorFinal() && rondasJugadas < RONDAS_TOTALES) {
            rondasJugadas++;
            jugarRonda(rondasJugadas);
        }

        mostrarResultadoFinal();
    }

    /**
     * Muestra la pantalla de bienvenida con las reglas del juego.
     * Usa caracteres especiales para crear un marco decorativo.
     */
    private void mostrarBienvenida() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║     BIENVENIDOS AL JUEGO DE LOS GLOBOS EXPLOSIVOS      ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Reglas:                                                ║");
        System.out.println("║ - Mejor de " + RONDAS_TOTALES + " rondas (gana quien gane " + rondasParaGanar + " rondas)            ║");
        System.out.println("║ - Cada globo tiene capacidad aleatoria (1-50)          ║");
        System.out.println("║ - Si explotas el globo, pierdes la ronda               ║");
        System.out.println("║ - Sistema de cansancio: si soplas mucho, la siguiente  ║");
        System.out.println("║   ronda podrás soplar menos (máx 11 en 2 rondas)       ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");

        // Mostramos los jugadores que participan
        System.out.println("\n=== JUGADORES ===");
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador j = jugadores.get(i);
            // Usamos instanceof para saber si es humano o CPU
            String tipo = j instanceof JugadorHumano ? "Humano" : "CPU";
            System.out.println((i + 1) + ". " + j.getNombre() + " (" + tipo + ")");
        }
    }

    /**
     * Juega una ronda completa:
     * 1. Crea un nuevo globo
     * 2. Los jugadores se turnan para soplar
     * 3. Cuando explota, asigna puntos al ganador
     *
     * @param numRonda Número de ronda actual (1-5)
     */
    private void jugarRonda(int numRonda) {
        // Separador visual para distinguir rondas
        System.out.println("\n══════════════════════════════════════════════════════════");
        System.out.println("                    RONDA " + numRonda + " de " + RONDAS_TOTALES);
        System.out.println("══════════════════════════════════════════════════════════");

        // Creamos un nuevo globo con capacidad aleatoria secreta
        Globo globo = new Globo();
        System.out.println("¡Nuevo globo creado con capacidad secreta!");

        mostrarMarcador();

        // Reiniciamos el cansancio de todos los jugadores al empezar la ronda
        // Esto simula que "descansan" entre rondas
        for (Jugador j : jugadores) {
            j.reiniciarCansancioRonda();
        }

        // Bucle de turnos dentro de la ronda
        int turnoActual = 0;
        boolean rondaTerminada = false;

        while (!rondaTerminada) {
            // Calculamos qué jugador le toca (cíclico: 0,1,2,3... y vuelta a 0)
            Jugador jugadorActual = jugadores.get(turnoActual % jugadores.size());

            // El jugador determina cuánto sopla (con sistema de cansancio)
            int cantidad = jugadorActual.determinarSoploConCansancio();
            globo.inflar(cantidad);

            // Comprobamos si explotó
            if (globo.haExplotado()) {
                // El globo explotó: el jugador actual pierde, el otro gana
                globo.mostrarExplosion();

                Jugador perdedor = jugadorActual;
                Jugador ganador = encontrarOtroJugador(jugadorActual);

                // Actualizamos estadísticas
                ganador.ganarRonda();
                perdedor.perderRonda();

                System.out.println("\n>>> " + perdedor.getNombre() + " ha explotado el globo y pierde la ronda!");
                System.out.println(">>> " + ganador.getNombre() + " gana la ronda!");

                rondaTerminada = true;
            } else {
                // El globo no explotó: mostramos su estado y continuamos
                globo.mostrarGrafico();

                // Mensaje de continuidad si no es el primer turno
                if (turnoActual >= jugadores.size() - 1) {
                    System.out.println("\nEl globo aguanta... ¡continúa el juego!");
                }
            }

            turnoActual++;
        }

        // Fin de la ronda: mostramos marcador y estadísticas
        System.out.println("\n--- Fin de la Ronda " + numRonda + " ---");
        mostrarMarcador();
        mostrarEstadisticasAire();
    }

    /**
     * Encuentra el otro jugador (diferente al excluido).
     * Para 2 jugadores, devuelve el que no es el perdedor.
     * NOTA: Con más de 2 jugadores, esto devuelve el primero que encuentre.
     */
    private Jugador encontrarOtroJugador(Jugador excluido) {
        for (Jugador j : jugadores) {
            if (!j.equals(excluido)) {
                return j;
            }
        }
        return jugadores.get(0); // Fallback (no debería pasar)
    }

    /** Muestra el marcador actual de rondas ganadas por cada jugador */
    private void mostrarMarcador() {
        System.out.println("\n--- MARCADOR ---");
        for (Jugador j : jugadores) {
            System.out.println(j.getNombre() + ": " + j.getRondasGanadas() + " rondas ganadas");
        }
    }

    /**
     * EXTRA: Muestra estadísticas de aire total soplado por cada jugador.
     * Esto permite ver quién ha soplado más a lo largo de la partida.
     */
    private void mostrarEstadisticasAire() {
        System.out.println("\n--- AIRE TOTAL SOPLADO ---");
        for (Jugador j : jugadores) {
            System.out.println(j.getNombre() + ": " + j.getAireTotalSoplado() + " unidades");
        }
    }

    // ===================================================================
    // LÓGICA DE FIN DE JUEGO
    // ===================================================================

    /**
     * Comprueba si algún jugador ha ganado suficientes rondas.
     * @return true si hay un ganador definitivo
     */
    private boolean hayGanadorFinal() {
        for (Jugador j : jugadores) {
            if (j.getRondasGanadas() >= rondasParaGanar) {
                return true;
            }
        }
        return false;
    }

    /**
     * Muestra el resultado final con todas las estadísticas.
     * Incluye: rondas perdidas, aire total soplado y el ganador.
     */
    private void mostrarResultadoFinal() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║                  RESULTADO FINAL                       ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");

        // Mostramos rondas perdidas (menor es mejor)
        System.out.println("\n--- RONDAS PERDIDAS (menor es mejor) ---");
        for (Jugador j : jugadores) {
            System.out.println(j.getNombre() + ": " + j.getRondasPerdidas() + " rondas perdidas");
        }

        // EXTRA: Mostramos aire total soplado
        System.out.println("\n--- AIRE TOTAL SOPLADO EN TODA LA PARTIDA ---");
        for (Jugador j : jugadores) {
            System.out.println(j.getNombre() + ": " + j.getAireTotalSoplado() + " unidades");
        }

        // Determinamos y mostramos el ganador
        Jugador ganador = determinarGanador();

        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        if (ganador != null) {
            System.out.println("║     " + centrarTexto(ganador.getNombre() + " GANA EL JUEGO !!!", 42) + "║");
        } else {
            System.out.println("║          ¡¡¡ EMPATE !!!                                ║");
        }
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }

    /**
     * Determina el ganador del juego basándose en:
     * 1. Quien tenga MENOS rondas perdidas (gana el que menos haya perdido)
     * 2. En caso de empate, quien tenga MÁS rondas ganadas
     * 3. Si sigue empatado, devuelve null (empate)
     *
     * @return El jugador ganador, o null si hay empate
     */
    private Jugador determinarGanador() {
        Jugador ganador = null;
        int minPerdidas = Integer.MAX_VALUE;

        // Primero buscamos quién tiene menos rondas perdidas
        for (Jugador j : jugadores) {
            if (j.getRondasPerdidas() < minPerdidas) {
                minPerdidas = j.getRondasPerdidas();
                ganador = j;
            } else if (j.getRondasPerdidas() == minPerdidas) {
                // Empate en rondas perdidas: gana quien tenga más rondas ganadas
                if (ganador != null && j.getRondasGanadas() > ganador.getRondasGanadas()) {
                    ganador = j;
                }
            }
        }

        // Contamos cuántos tienen el mínimo de rondas perdidas
        int countMinPerdidas = 0;
        for (Jugador j : jugadores) {
            if (j.getRondasPerdidas() == minPerdidas) {
                countMinPerdidas++;
            }
        }

        // Si hay más de uno con el mínimo, es empate
        return countMinPerdidas == 1 ? ganador : null;
    }

    /**
     * Utilidad para centrar texto en un ancho determinado.
     * Usado para formatear el recuadro del ganador.
     */
    private String centrarTexto(String texto, int ancho) {
        if (texto.length() >= ancho) {
            return texto;
        }
        int espaciosIzquierda = (ancho - texto.length()) / 2;
        int espaciosDerecha = ancho - texto.length() - espaciosIzquierda;
        return " ".repeat(espaciosIzquierda) + texto + " ".repeat(espaciosDerecha);
    }
}
