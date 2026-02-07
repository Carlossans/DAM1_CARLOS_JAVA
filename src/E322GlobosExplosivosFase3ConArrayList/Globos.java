package E322GlobosExplosivosFase3ConArrayList;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Globos {
    private int capacidad;
    private int aireActual;

    public Globos() {
        // Capacidad aleatoria entre 10 y 50
        Random aleatorio = new Random();
        this.capacidad = aleatorio.nextInt(41) + 10;
        this.aireActual = 0;
    }

    public void inflar(int cantidad) {
        this.aireActual += cantidad;
    }

    public boolean explotado() {
        return aireActual > capacidad;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < aireActual && i < capacidad; i++) {
            sb.append("*");
        }
        for (int i = aireActual; i < capacidad; i++) {
            sb.append("O");
        }

        String resultado = sb.toString();
        if (explotado()) {
            resultado += " BOOM";
        }
        return resultado;
    }
}

class Partida {
    private ArrayList<Globos> globos;
    private int victoriasJugador1;
    private int victoriasJugador2;
    private Scanner teclado;

    public Partida() {
        this.globos = new ArrayList<>();
        this.victoriasJugador1 = 0;
        this.victoriasJugador2 = 0;
        this.teclado = new Scanner(System.in);

        // Se crean los 5 globos de la partida
        for (int i = 0; i < 5; i++) {
            globos.add(new Globos());
        }
    }

    public void jugar() {
        System.out.println("INICIO DEL JUEGO DE LOS GLOBOS EXPLOSIVOS");

        for (int ronda = 0; ronda < 5; ronda++) {
            System.out.println("\nRONDA " + (ronda + 1));
            Globos globoActual = globos.get(ronda);

            boolean turnoJugador1 = true;
            while (!globoActual.explotado()) {
                int jugador = turnoJugador1 ? 1 : 2;
                System.out.print("Jugador " + jugador + ", ¿cuánto aire soplas?: ");
                int soplo = teclado.nextInt();
                globoActual.inflar(soplo);

                System.out.println("Estado: " + globoActual.toString());

                if (globoActual.explotado()) {
                    if (turnoJugador1) {
                        System.out.println("Explotó. Gana el Jugador 2");
                        victoriasJugador2++;
                    } else {
                        System.out.println("Explotó. Gana el Jugador 1");
                        victoriasJugador1++;
                    }
                }
                turnoJugador1 = !turnoJugador1;
            }

            System.out.println("PUNTUACIÓN J1 [" + victoriasJugador1 + "] - J2 [" + victoriasJugador2 + "]");
            if (victoriasJugador1 == 3 || victoriasJugador2 == 3) {
                break;
            }
        }

        mostrarResultadoFinal();
    }

    private void mostrarResultadoFinal() {
        System.out.println("\n--- RESULTADO FINAL ---");
        if (victoriasJugador1 > victoriasJugador2) {
            System.out.println("EL GANADOR ES EL JUGADOR 1");
        } else {
            System.out.println("EL GANADOR ES EL JUGADOR 2");
        }

        System.out.println("\nRESUMEN DE LOS 5 GLOBOS:");
        for (int i = 0; i < globos.size(); i++) {
            System.out.println("Globo " + (i + 1) + ": " + globos.get(i).toString());
        }
    }
}
