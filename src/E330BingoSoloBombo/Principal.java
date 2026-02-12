package E330BingoSoloBombo;

public class Principal {
    public static void main(String[] args) {
        Bombo bombo1 = new Bombo(15);
        Carton carton1 = new Carton(10, bombo1);
        int contador = 0;

        while (bombo1.hayBolas() && !carton1.hayBingo()) {

            int bola = bombo1.dameBola();

            if (contador == 0) {
                System.out.println(carton1);
                contador++;
            }

            carton1.anotaBola(bola);

            System.out.printf("\nHa salido la bola %d \n\n%s\n", bola, carton1);

            //System.out.println("\n¿Ha salido la bola 10? " + bombo1.bolaEstaDentro(10));

        }

        System.out.println(
                (carton1.hayBingo()) ? "\nBINGO" : "\nNo hay bingo"
        );

        System.out.println(bombo1);

    }
}
