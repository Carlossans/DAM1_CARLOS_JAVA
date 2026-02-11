package E330BingoSoloBombo;

public class Principal {
    public static void main(String[] args) {
        Bombo bombo1 = new Bombo(60);

        while (bombo1.hayBolas()) {
            System.out.println("\nHa salido la bola " + bombo1.dameBola() + "\n");

            System.out.println("\n¿Ha salido la bola 10? " + bombo1.bolaEstaDentro(10));

        }

        System.out.println(bombo1);

        System.out.println("\nSe han sacado todas las bolas");

    }
}
