package E330BingoSoloBombo;

public class Principal {
    public static void main(String[] args) {
        Bombo bombo1 = new Bombo(60);

        System.out.println(bombo1.dameBola());

        System.out.println(bombo1.bolaEstaDentro(10));

        System.out.println(bombo1);
    }
}
