package E935TecladoEstropeado144;

import java.util.ArrayList;
import java.util.Scanner;

public class E935TecladoEstropeado144 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<Character> letras;
        String presionadas;
        int posicion;

        while (teclado.hasNext()) {

            presionadas = teclado.nextLine();

            posicion = 0; letras = new ArrayList<>();
            for (int i = 0; i < presionadas.length(); i++) {
                switch (presionadas.charAt(i)) {
                    case '-': posicion = 0; break;
                    case '*': posicion++; break;
                    case '3':
                        if (!letras.isEmpty() && posicion <= letras.size() - 1)
                            letras.remove(posicion); break;
                    case '+':
                        if (letras.isEmpty()) posicion = 0;
                        else posicion = letras.size();
                        break;
                    default:
                        if (posicion > letras.size())
                            if (!letras.isEmpty()) posicion = letras.size();
                            else posicion = 0;
                        letras.add(posicion++, presionadas.charAt(i));
                }
            }

            for (Character c : letras) System.out.print(c + "");
            System.out.println();
        }

    }
}
