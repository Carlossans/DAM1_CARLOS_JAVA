package Ejercicios_navidad;

import java.util.Scanner;

public class E224AnalizadorDeTexto {
    private static int contarPalabras(String frase) {
        int contador = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                contador++;
            }
        }
        return contador;
    }

    private static int contarPalabrasLargas(String frase) {
        int contador = 0, contadorLargas = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) != ' ') {
                contador++;
                if (contador >= 5) {
                    contadorLargas++;
                    contador = 0;
                }
            } else {
                contador = 0;
            }
        }
        return contadorLargas;
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("\nIntroduce una frase de la longitud que tu quieras: ");
        String frase = teclado.nextLine();

        frase = frase + " ";

        System.out.println("\nLa frase que has introducido tiene " + contarPalabras(frase) + " palabras");

        System.out.println("\nLa frase que has introducido tiene " + contarPalabrasLargas(frase) + " palabras largas");
    }
}
