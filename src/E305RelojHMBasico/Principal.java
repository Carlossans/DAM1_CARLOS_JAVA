package E305RelojHMBasico;

public class Principal {
    public static void main(String[] args) {
        Reloj[] relojes = new Reloj[] {new RelojDigital(17, 40), new RelojTextual.RelojEspaniol(14, 13), new RelojTextual.RelojIngles(12, 00), new RelojAnalogico(14, 20)};


        for (Reloj reloj : relojes) {
            System.out.println(reloj);
        }
    }
}
