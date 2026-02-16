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
        this.aleatorio = new Random();
        // Inicializamos el bombo con entre 60 y 90 bolas
        this.bombo = new Bombo(aleatorio.nextInt(60, 91));
        this.cartones = new ArrayList<>();
        this.ganadores = new ArrayList<>();
        this.alguienTieneBingo = false;
        this.lineaYaCantadaEnPartida = false;

        // Decidimos cuántos cartones habrá
        this.numCartones = aleatorio.nextInt(2, 6);

        // Creamos los cartones
        for (int i = 0; i < numCartones; i++) {
            cartones.add(new Carton(bombo));
        }
    }

    public void jugar() throws InterruptedException {
        mostrarBienvenida();

        // Bucle principal del juego
        while (bombo.hayBolas() && !alguienTieneBingo) {
            int bola = bombo.dameBola();
            limpiarPantalla();
            System.out.printf("BOLA: %s%02d%s\n", AZUL, bola, RESET);

            procesarBolaEnCartones(bola);
            mostrarCartones();

            if (!alguienTieneBingo) {
                sleep(2500);
            }
        }

        mostrarResultadosFinales();
    }

    private void procesarBolaEnCartones(int bola) throws InterruptedException {
        for (Carton carton : cartones) {
            carton.anotaBola(bola);

            // Lógica de Línea
            if (!lineaYaCantadaEnPartida && carton.hayLinea()) {
                System.out.printf("\n%sLÍNEA EN EL CARTÓN %d%s\n\n", AMARILLO, carton.getId(), RESET);
                lineaYaCantadaEnPartida = true;
                sleep(2000);
            }

            // Lógica de Bingo
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
