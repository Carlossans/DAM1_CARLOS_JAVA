package E303NumeroInteligenteBasico;

public class Principal {
    public static void main(String[] args) {
        NumeroInteligente n = new NumeroInteligente();
        for (int i = 1; i <= 100; i++) {
            n.setValor(i);
            if (n.esPrimo()) {
                IO.println(i + " es primo");
            } else {
                IO.println(i + " no es primo");
            }
        }
        IO.println();

        NumeroInteligente n2 = new NumeroInteligente();
        int contadorPrimos = 0;
        int proceso = 1;

        while (contadorPrimos < 100) {
            n2.setValor(proceso);
            if (n2.esPrimo()) {
                IO.println(proceso + " es un número primo");
                contadorPrimos++;
            }
            proceso++;
        }
    }
}