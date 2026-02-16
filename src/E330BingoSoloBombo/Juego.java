package E330BingoSoloBombo;

import java.util.ArrayList;
import java.util.Random;
import static java.lang.Thread.sleep;

public class Juego {
    private static final String AZUL = "\u001B[34m";
    private static final String AMARILLO = "\u001B[33m";
    private static final String RESET = "\u001B[0m";

    private Bombo bombo;
    private ArrayList<Carton> cartones;
    private ArrayList<Carton> ganadores;
    private boolean alguienTieneBingo;
    private boolean lineaYaCantadaEnPartida;
    private int numCartones;
    private Random aleatorio;

    public Juego() {
        aleatorio = new Random();
        bombo = new Bombo(aleatorio.nextInt(60, 91));
        cartones = new ArrayList<>();
        ganadores = new ArrayList<>();
        alguienTieneBingo = false;
        lineaYaCantadaEnPartida = false;

        numCartones = aleatorio.nextInt(2, 6);

        for (int i = 0; i < numCartones; i++) {
            cartones.add(new Carton(bombo));
        }
    }

    public void jugar() throws InterruptedException {
        mostrarBienvenida();

        while (bombo.hayBolas() && !alguienTieneBingo) {
            int bola = bombo.dameBola();
            limpiarPantalla();
            System.out.printf("BOLA: %s%02d%s\n", AZUL, bola, RESET);

            procesarBolaEnCartones(bola);
            mostrarCartones();

            if (!alguienTieneBingo) {
                sleep(5000);
            }
        }

        mostrarResultadosFinales();
    }

    private void procesarBolaEnCartones(int bola) throws InterruptedException {
        for (Carton carton : cartones) {
            carton.anotaBola(bola);

            if (!lineaYaCantadaEnPartida && carton.hayLinea()) {
                System.out.printf("\n%sLÍNEA EN EL CARTÓN %d%s\n\n", AMARILLO, carton.getId(), RESET);
                lineaYaCantadaEnPartida = true;
                sleep(3500);
            }

            if (carton.hayBingo()) {
                alguienTieneBingo = true;
                ganadores.add(carton);
            }
        }
    }

    private void mostrarBienvenida() throws InterruptedException {
        limpiarPantalla();
        System.out.printf("%sBIENVENIDO AL GRAN BINGO DEL I.E.S LAGUNA DE JOATZEL%s\n", AZUL, RESET);
        System.out.printf("\nEL BOMBO TIENE %d BOLAS Y EL JUEGO CUENTA CON %d CARTONES\n\n",
                bombo.getTotalBolas(), numCartones);
        mostrarCartones();
        sleep(3000);
    }

    private void mostrarCartones() {
        for (Carton carton : cartones) {
            System.out.println(carton);
        }
    }

    private void limpiarPantalla() {
        System.out.println("\n".repeat(30));
    }

    private void mostrarResultadosFinales() {
        System.out.println("\n".repeat(5));
        if (alguienTieneBingo) {
            if (ganadores.size() > 1) {
                System.out.println("HAY EMPATE, LOS SIGUIENTES CARTONES HAN CANTADO BINGO:");
                for (Carton ganador : ganadores) {
                    System.out.println("\n" + ganador);
                }
            } else {
                System.out.printf("\n%sBINGO, EL CARTÓN GANADOR ES:%s\n %s\n",
                        AMARILLO, RESET, ganadores.getFirst());
            }
        } else {
            System.out.println("Se han acabado las bolas. Nadie cantó bingo");
        }
        System.out.println(bombo);
    }
}
