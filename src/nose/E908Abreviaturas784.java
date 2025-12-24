package nose;

import java.util.Scanner;

public class E908Abreviaturas784 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int casosPrueba = Integer.parseInt(teclado.nextLine());

        for (int i = 0; i < casosPrueba; i++) {
            String palabra= teclado.nextLine().replaceAll("\\s" , "");

            StringBuilder abreviatura = new StringBuilder();

            for (int pos = 0; pos < palabra.length(); pos++) {
                char letra = palabra.charAt(pos);

                if (Character.isLetter(letra)) abreviatura.append(letra).append(letra).append(". ");
            }
            System.out.println(abreviatura.toString().trim());
        }
    }
}