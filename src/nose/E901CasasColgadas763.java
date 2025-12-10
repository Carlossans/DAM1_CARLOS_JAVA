package nose;

import java.util.Scanner;

public class E901CasasColgadas763 {
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);

        int casosPrueba = teclado.nextInt();
        teclado.nextLine();

        for (int i = 0; i < casosPrueba; i++) {
            String palabra = teclado.next().toLowerCase();

            if (palabra.equals("colgadas")) System.out.println("Bien");
            else System.out.println("Mal");
        }
    }
}