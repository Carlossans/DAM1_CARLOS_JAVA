package E330BingoSoloBombo;

import java.util.Random;
import java.util.ArrayList;
import static java.lang.Thread.sleep;

public class Principal {
    private static final String AZUL = "\u001B[34m";
    private static final String RESET = "\u001B[0m";

    public static void main(String[] args) throws InterruptedException {
        Random aleatorio = new Random();
        Bombo bombo = new Bombo(aleatorio.nextInt(15, 91));
        ArrayList<Carton> cartones = new ArrayList<>();
        ArrayList<Carton> ganadores = new ArrayList<>();
        boolean alguienTieneBingo = false;

        int numCartones = aleatorio.nextInt(1, 6);
        for (int i = 0; i < numCartones; i++) {
            cartones.add(new Carton(bombo));
        }

        System.out.printf("\n%sBIENVENIDO AL GRAN BINGO DEL I.E.S LAGUNA DE JOATZEL%s\n", AZUL, RESET);

        System.out.printf(
                (numCartones  > 1 ) ? "\nEl BOMBO TIENE %d BOLAS Y EL JUEGO TIENE %d CARTONES\n\n" : "\nEl BOMBO TIENE %d BOLAS Y EL JUEGO TIENE %d CARTÓN\n\n"
        ,bombo.getTotalBolas(), numCartones);

        for (Carton carton : cartones) {
            System.out.println(carton + "\n");
        }

        while (bombo.hayBolas() && !alguienTieneBingo) {
            int bola = bombo.dameBola();

            System.out.println("\n".repeat(10));
            System.out.printf("BOLA: %s %d %s\n\n", AZUL, bola, RESET);

            for (Carton carton : cartones) {
                carton.anotaBola(bola);

                if (carton.hayBingo()) {
                    alguienTieneBingo = true;
                    ganadores.add(carton);
                }
            }

            for (Carton carton : cartones) {
                System.out.println(carton + "\n");
            }
            //sleep(4000);

            if (alguienTieneBingo) {
                System.out.println("\n".repeat(10));
                System.out.println("ÚLTIMA BOLA SACADA: " + bola);

                if (ganadores.size() > 1) {
                    System.out.println("\nESTOS CARTONES GANADORES HAN CANTADO BINGO AL MISMO TIEMPO\n");

                    for (Carton ganador : ganadores) {
                        System.out.println(ganador + "\n");
                    }
                } else {
                    System.out.println("\nEL CARTÓN QUE HA CANTADO BINGO ES El:\n");
                    System.out.println(ganadores.getFirst() + "\n");
                }
            }
        }

        if (!alguienTieneBingo) {
            System.out.println("Se han sacado todas las bolas del bombo y no hay ganadores");
        }

        System.out.println("\n".repeat(10));
        System.out.println(bombo);
    }
}
