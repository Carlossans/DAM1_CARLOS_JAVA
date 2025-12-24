package nose;

import java.util.Scanner;

public class E906CuantosDiasFaltan157 {
    private static final int diaNocheVieja = 31;
    private static final int mesNocheVieja = 12;
    private static final int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int numCasos = teclado.nextInt();

        for (int i = 0; i < numCasos; i++) {
            int diasRestantes = 0;
            int dia = teclado.nextInt();
            int mes = teclado.nextInt();

            if (mes == mesNocheVieja) {
                diasRestantes = diaNocheVieja - dia;
                System.out.println(diasRestantes);
            } else {
                diasRestantes = diasRestantes + (diasPorMes[mes - 1] - dia);

                for (int j = mes; j < mesNocheVieja; j++) {
                    diasRestantes = diasRestantes + diasPorMes[j];
                }
                System.out.println(diasRestantes);
            }
        }
    }
}
