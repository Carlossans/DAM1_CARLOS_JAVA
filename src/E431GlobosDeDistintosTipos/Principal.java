package b400ooavanzada.E430GlobosConJugadoresMixtos;

import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // TODO En este punto, se le puede preguntar al usuario cuántas rondas quiere (debe ser impar).

        int vidasPorJugador = 3;

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new JugadorCpu("Fulanito", vidasPorJugador));
        jugadores.add(new JugadorCpu("Menganita", vidasPorJugador));
        jugadores.add(new JugadorCpu("Zutanito", vidasPorJugador));
        jugadores.add(new JugadorCpu("Fulanítez", vidasPorJugador));
        jugadores.add(new JugadorCpu("Menganítez", vidasPorJugador));
        int jugadoresVivos = jugadores.size();
        int jugadorActual = -1; // Ponemos -1 porque lo primero que se hace es cambiar de jugador. Así, pasará a empezar el 0.

        int ronda = 0;
        do {
            ronda++;

            System.out.printf("\n\n\n---------- RONDA %d ----------\n", ronda);
            for (Jugador jugador : jugadores) System.out.printf("  - %s\n", jugador);

            Globo globo = new Globo();
            System.out.println(globo);

            do {
                do { // Saltar a los jugadores que ya no estén vivos.
                    jugadorActual = (jugadorActual + 1) % jugadores.size();
                } while (!jugadores.get(jugadorActual).estaVivo());
                // También podría hacerse así:
                //   if (jugadorActual == jugadores.size()-1) jugadorActual = 0;
                //   else jugadorActual++;
                // O así:
                //   jugadorActual = (jugadorActual == jugadores.size()-1) ? 0 : jugadorActual+1;

                jugadores.get(jugadorActual).soplar(globo);

                System.out.println(globo);
            } while (!globo.explotado());

            jugadores.get(jugadorActual).quitarUnaVida();
            if (!jugadores.get(jugadorActual).estaVivo()) jugadoresVivos--;
        } while (jugadoresVivos > 1);

        jugadores.sort(Comparator.reverseOrder());

        System.out.printf("\n\n\n---------- FINAL DEL JUEGO TRAS %d RONDAS ----------\n", ronda);
        for (Jugador jugador : jugadores) System.out.printf("  - %s\n", jugador);

        System.out.printf("\n Por lo tanto, el ganador es:\n  %s\n\n\n", jugadores.getFirst());
    }
}