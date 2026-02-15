package E330BingoSoloBombo;

import java.util.Random;
import java.util.ArrayList;
import static java.lang.Thread.sleep;

public class Principal {
    private static final String AZUL = "\u001B[34m";
    private static final String AMARILLO = "\u001B[33m";
    private static final String RESET = "\u001B[0m";

    public static void main(String[] args) throws InterruptedException {
        Random aleatorio = new Random();
        Bombo bombo = new Bombo(aleatorio.nextInt(60, 91));
        ArrayList<Carton> cartones = new ArrayList<>();
        ArrayList<Carton> ganadores = new ArrayList<>();

        boolean alguienTieneBingo = false;
        boolean lineaYaCantadaEnPartida = false;

        int numCartones = aleatorio.nextInt(2, 6);

        for (int i = 0; i < numCartones; i++) {
            cartones.add(new Carton(bombo));
        }

        System.out.println("\n".repeat(30));
        System.out.printf("%sBIENVENIDO AL GRAN BINGO DEL I.E.S LAGUNA DE JOATZEL%s\n", AZUL, RESET);

        System.out.printf(
                (numCartones > 1) ? "\nEL BOMBO TIENE %d BOLAS Y EL JUEGO CUENTA CON %d CARTONES\n\n"
                        : "\nEL BOMBO TIENE %d BOLAS Y EL JUEGO CUENTA CON %d CARTÓN\n\n",
                bombo.getTotalBolas(), numCartones);

        for (Carton carton : cartones) {
            System.out.println(carton);
        }

        sleep(3000);

        while (bombo.hayBolas() && !alguienTieneBingo) {
            int bola = bombo.dameBola();

            System.out.println("\n".repeat(30));
            System.out.printf("BOLA: %s%02d%s\n", AZUL, bola, RESET);

            for (Carton carton : cartones) {
                carton.anotaBola(bola);

                if (!lineaYaCantadaEnPartida && carton.hayLinea()) {
                    System.out.printf("\n%sLÍNEA EN EL CARTÓN %d%s\n", AMARILLO, carton.getId(), RESET);
                    lineaYaCantadaEnPartida = true;
                    sleep(2000);
                }

                if (carton.hayBingo()) {
                    alguienTieneBingo = true;
                    ganadores.add(carton);
                }
            }

            for (Carton carton : cartones) {
                System.out.println(carton);
            }

            if (!alguienTieneBingo) {
                sleep(2500);
            }
        }

        System.out.println("\n".repeat(5));
        if (alguienTieneBingo) {
            if (ganadores.size() > 1) {
                System.out.println("HAY EMPATE, LOS SIGUIENTES CARTONES HAN CANTADO BINGO:");
                for (Carton ganador : ganadores) {
                    System.out.println("\n" + ganador);
                }
            } else {
                System.out.printf("\n%sBINGO, EL CARTÓN GANADOR ES:%s\n %s\n", AMARILLO, RESET, ganadores.getFirst());
            }
        } else {
            System.out.println("Se han acabado las bolas. Nadie cantó bingo");
        }

        System.out.println(bombo);
    }
}