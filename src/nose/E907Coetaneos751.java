package nose;

import java.util.Scanner;

public class E907Coetaneos751 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int casosPrueba = teclado.nextInt();

        for (int i = 0; i < casosPrueba; i++) {

            int nacimiento1 = teclado.nextInt();
            int muerte1 = teclado.nextInt();

            int nacimiento2 = teclado.nextInt();
            int muerte2 = teclado.nextInt();

            int anioCoincidencia = Math.max(nacimiento1, nacimiento2);
            int finCoincidencia = Math.min(muerte1, muerte2);

            int coexistencia;

            coexistencia = (anioCoincidencia > finCoincidencia) ? 0 : (finCoincidencia - anioCoincidencia) + 1;

            System.out.println(coexistencia);
        }
    }
}
