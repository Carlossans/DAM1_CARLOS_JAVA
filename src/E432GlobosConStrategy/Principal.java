package E432GlobosConStrategy;

import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int vidasPorJugador = 3;

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Fulanito (CPU Aleatoria)", vidasPorJugador, new SoploAleatorio()));
        jugadores.add(new Jugador("Menganita (Humano)", vidasPorJugador, new SoploHumano()));
        jugadores.add(new Jugador("Zutanito (Prudente)", vidasPorJugador, new SoploPrudente()));
        jugadores.add(new Jugador("Fulanítez (Temerario)", vidasPorJugador, new SoploTemerario()));

        int jugadoresVivos = jugadores.size();
        int jugadorActual = -1;

        int ronda = 0;
        do {
            ronda = ronda + 1;

            System.out.printf("\n\n\n---------- RONDA %d ----------\n", ronda);
            for (Jugador jugador : jugadores) System.out.printf("  - %s\n", jugador);

            Globo globo = new GloboNormal();
            System.out.println(globo);

            do {
                do {
                    jugadorActual = (jugadorActual + 1) % jugadores.size();
                } while (!jugadores.get(jugadorActual).estaVivo());

                jugadores.get(jugadorActual).soplar(globo);

                System.out.println(globo);
            } while (!globo.explotado());

            jugadores.get(jugadorActual).quitarUnaVida();
            if (!jugadores.get(jugadorActual).estaVivo()) {
                jugadoresVivos = jugadoresVivos - 1;
            }
        } while (jugadoresVivos > 1);

        jugadores.sort(Comparator.reverseOrder());

        System.out.printf("\n\n\n---------- FINAL DEL JUEGO TRAS %d RONDAS ----------\n", ronda);
        for (Jugador jugador : jugadores) System.out.printf("  - %s\n", jugador);

        System.out.printf("\n Por lo tanto, el ganador es:\n  %s\n\n\n", jugadores.getFirst());
    }
}