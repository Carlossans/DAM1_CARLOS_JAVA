package E430GlobosConJugadoresMixtos;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private List<Jugador> jugadores;
    private int rondasParaGanar;
    private int rondasJugadas;
    private static final int RONDAS_TOTALES = 5;

    public Juego() {
        this.jugadores = new ArrayList<>();
        this.rondasParaGanar = (RONDAS_TOTALES / 2) + 1;
        this.rondasJugadas = 0;
    }

    public void configurar() {
        jugadores = Jugador.configurarJugadores();
    }

    public void empezar() {
        mostrarBienvenida();

        while (!hayGanadorFinal() && rondasJugadas < RONDAS_TOTALES) {
            rondasJugadas++;
            jugarRonda(rondasJugadas);
        }

        mostrarResultadoFinal();
    }

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

        System.out.println("\n=== JUGADORES ===");
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador j = jugadores.get(i);
            System.out.println((i + 1) + ". " + j.getNombre() + " (" + (j instanceof JugadorHumano ? "Humano" : "CPU") + ")");
        }
    }

    private void jugarRonda(int numRonda) {
        System.out.println("\n══════════════════════════════════════════════════════════");
        System.out.println("                    RONDA " + numRonda + " de " + RONDAS_TOTALES);
        System.out.println("══════════════════════════════════════════════════════════");

        Globo globo = new Globo();
        System.out.println("¡Nuevo globo creado con capacidad secreta!");

        mostrarMarcador();

        int turnoActual = 0;
        boolean rondaTerminada = false;

        for (Jugador j : jugadores) {
            j.reiniciarCansancioRonda();
        }

        while (!rondaTerminada) {
            Jugador jugadorActual = jugadores.get(turnoActual % jugadores.size());

            int cantidad = jugadorActual.determinarSoploConCansancio();
            globo.inflar(cantidad);

            if (globo.haExplotado()) {
                globo.mostrarExplosion();
                Jugador perdedor = jugadorActual;
                Jugador ganador = encontrarOtroJugador(jugadorActual);

                ganador.ganarRonda();
                perdedor.perderRonda();

                System.out.println("\n>>> " + perdedor.getNombre() + " ha explotado el globo y pierde la ronda!");
                System.out.println(">>> " + ganador.getNombre() + " gana la ronda!");

                rondaTerminada = true;
            } else {
                globo.mostrarGrafico();

                if (turnoActual >= jugadores.size() - 1) {
                    System.out.println("\nEl globo aguanta... ¡continúa el juego!");
                }
            }

            turnoActual++;
        }

        System.out.println("\n--- Fin de la Ronda " + numRonda + " ---");
        mostrarMarcador();
        mostrarEstadisticasAire();
    }

    private Jugador encontrarOtroJugador(Jugador excluido) {
        for (Jugador j : jugadores) {
            if (!j.equals(excluido)) {
                return j;
            }
        }
        return jugadores.get(0);
    }

    private void mostrarMarcador() {
        System.out.println("\n--- MARCADOR ---");
        for (Jugador j : jugadores) {
            System.out.println(j.getNombre() + ": " + j.getRondasGanadas() + " rondas ganadas");
        }
    }

    private void mostrarEstadisticasAire() {
        System.out.println("\n--- AIRE TOTAL SOPLADO ---");
        for (Jugador j : jugadores) {
            System.out.println(j.getNombre() + ": " + j.getAireTotalSoplado() + " unidades");
        }
    }

    private boolean hayGanadorFinal() {
        for (Jugador j : jugadores) {
            if (j.getRondasGanadas() >= rondasParaGanar) {
                return true;
            }
        }
        return false;
    }

    private void mostrarResultadoFinal() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║                  RESULTADO FINAL                       ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");

        System.out.println("\n--- RONDAS PERDIDAS (menor es mejor) ---");
        for (Jugador j : jugadores) {
            System.out.println(j.getNombre() + ": " + j.getRondasPerdidas() + " rondas perdidas");
        }

        System.out.println("\n--- AIRE TOTAL SOPLADO EN TODA LA PARTIDA ---");
        for (Jugador j : jugadores) {
            System.out.println(j.getNombre() + ": " + j.getAireTotalSoplado() + " unidades");
        }

        Jugador ganador = determinarGanador();

        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        if (ganador != null) {
            System.out.println("║     ¡¡¡ " + centrarTexto(ganador.getNombre() + " GANA EL JUEGO !!!", 42) + "║");
        } else {
            System.out.println("║          ¡¡¡ EMPATE !!!                                ║");
        }
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }

    private Jugador determinarGanador() {
        Jugador ganador = null;
        int minPerdidas = Integer.MAX_VALUE;

        for (Jugador j : jugadores) {
            if (j.getRondasPerdidas() < minPerdidas) {
                minPerdidas = j.getRondasPerdidas();
                ganador = j;
            } else if (j.getRondasPerdidas() == minPerdidas) {
                if (ganador != null && j.getRondasGanadas() > ganador.getRondasGanadas()) {
                    ganador = j;
                }
            }
        }

        int countMinPerdidas = 0;
        for (Jugador j : jugadores) {
            if (j.getRondasPerdidas() == minPerdidas) {
                countMinPerdidas++;
            }
        }

        return countMinPerdidas == 1 ? ganador : null;
    }

    private String centrarTexto(String texto, int ancho) {
        if (texto.length() >= ancho) {
            return texto;
        }
        int espaciosIzquierda = (ancho - texto.length()) / 2;
        int espaciosDerecha = ancho - texto.length() - espaciosIzquierda;
        return " ".repeat(espaciosIzquierda) + texto + " ".repeat(espaciosDerecha);
    }
}
