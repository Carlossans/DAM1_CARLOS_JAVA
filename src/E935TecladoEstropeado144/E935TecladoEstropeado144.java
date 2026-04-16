package E935TecladoEstropeado144;

import java.util.ArrayList;
import java.util.Scanner;

public class E935TecladoEstropeado144 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        while (teclado.hasNext()) {
            String presionadas = teclado.nextLine();
            int posicion = 0;
            ArrayList<Character> letras = new ArrayList<>();
            for (char caracter : presionadas.toCharArray()) {
                switch (caracter) {
                    case '-': posicion = 0; break;
                    case '*': posicion++; break;
                    case '3':
                        if (!letras.isEmpty() && posicion <= letras.size() - 1)
                            letras.remove(posicion); break;
                    case '+': posicion = letras.isEmpty() ? 0 : letras.size(); break;
                    default:
                        if (posicion > letras.size())
                            posicion = letras.isEmpty() ? 0 : letras.size();
                        letras.add(posicion++, caracter);
                }
            }
            letras.forEach(System.out::println);
        }
    }
}
