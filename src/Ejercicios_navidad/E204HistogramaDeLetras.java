package Ejercicios_navidad;

import java.util.Scanner;

public class E204HistogramaDeLetras {
    private static String fraseFormateada(String frase) {
        return frase.replace("á" , "a").replace("é" , "e").replace("í" , "i").replace("ó" , "o").replace("ú" , "u").replace("ü" , "u").replaceAll("\\s" , "").toLowerCase();
    }
    private static final char[] ABECEDARIO = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static  void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce la frase que quieras: ");
        String frase = teclado.nextLine();
        String fraseFormateada = fraseFormateada(frase);

        for (char letraAbecedario : ABECEDARIO) {
            int contador = 0;
            for (int letraFrase = 0; letraFrase < fraseFormateada.length(); letraFrase++) {
                if (fraseFormateada.charAt(letraFrase) == letraAbecedario) {
                    if (contador == 0) System.out.print(" " + letraAbecedario + ": *");
                    else System.out.print('*');
                    contador++;
                }
            }
        }
    }
}
