package E330BingoSoloBombo;

import java.util.Random;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        Bombo bombo = new Bombo(aleatorio.nextInt(15, 91));
        ArrayList<Carton> cartones = new ArrayList<>();
        ArrayList<Carton> ganadores = new ArrayList<>();
        boolean alguienTieneBingo = false;

        int numCartones = aleatorio.nextInt(1, 6);
        for (int i = 0; i < numCartones; i++) {
            cartones.add(new Carton(bombo));
        }

        System.out.println("\nEL JUEGO TIENE " + numCartones + " CARTONES:\n");

        for (Carton carton : cartones) {
            System.out.println(carton + "\n");
        }

        System.out.println("\n El BOMBO TIENE " + bombo.getTotalBolas() + "BOLAS\n");

        while (bombo.hayBolas() && !alguienTieneBingo) {
            int bola = bombo.dameBola();

            for (Carton carton : cartones) {
                carton.anotaBola(bola);

                if (carton.hayBingo()) {
                    alguienTieneBingo = true;
                    ganadores.add(carton);
                }
            }

            if (alguienTieneBingo) {
                System.out.println("\nÚLTIMA BOLA SACADA: " + bola);

                if (ganadores.size() > 1) {
                    System.out.println("\nHAY EMPATE ENTRE ESTOS CARTONES GANADORES\n");

                    for (Carton ganador : ganadores) {
                        System.out.println(ganador + "\n");
                    }
                } else {
                    System.out.println("\nEL GANADOR ES EL SIGUIENTE CARTÓN\n");
                    System.out.println(ganadores.get(0));
                }
            }
        }

        if (!alguienTieneBingo) {
            System.out.println("Se han sacado todas las bolas del bombo y no hay ganadores");
        }
        System.out.println(bombo);
    }
}
