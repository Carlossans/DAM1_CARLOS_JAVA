package E330BingoSoloBombo;

import E330BingoSoloBombo.Bombo.carton;

public class Principal {
    public static void main(String[] args) {
        Bombo bombo1 = new Bombo(15);
        Carton carton1 = new Carton(10, bombo1);

        while (bombo1.hayBolas() && !carton1.hayBingo()) {
            System.out.println(carton1);

            System.out.println("\nHa salido la bola " + bombo1.dameBola() + "\n");

            System.out.println(carton1);

            System.out.println("\n¿Ha salido la bola 10? " + bombo1.bolaEstaDentro(10));

        }

        System.out.println(
            (carton1.hayBingo()) ? "\nBINGO" : "\nNo hay bingo"
        );

    }
}
