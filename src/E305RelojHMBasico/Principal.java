package E305RelojHMBasico;

import java.util.Arrays;

public class Principal {
    public static void main(String[] args) {
        Reloj[] relojes = new Reloj[] {new RelojDigital(17, 40), new RelojTextual.RelojEspaniol(14, 13), new RelojTextual.RelojIngles(12, 00)};


        for (Reloj reloj : relojes) {
            System.out.println(reloj);
        }
    }
}
