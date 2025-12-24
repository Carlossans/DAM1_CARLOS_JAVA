package nose;

import java.util.Scanner;

public class E913DibujarTablerosAjedrez162 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while (true) {
            int n = teclado.nextInt(); // tamaño de cada escaque
            if (n == 0) {
                break; // fin de entrada
            }
            String blackChar = teclado.next(); // caracter para casillas negras

            int totalSize = 8 * n; // tamaño en filas y columnas del tablero

            // línea superior
            System.out.print("|");
            for (int i = 0; i < totalSize; i++) {
                System.out.print("-");
            }
            System.out.println("|");

            // dibujar las filas del tablero
            for (int row = 0; row < 8; row++) {
                for (int lineInSquare = 0; lineInSquare < n; lineInSquare++) {
                    System.out.print("|");
                    for (int col = 0; col < 8; col++) {
                        boolean isBlack;
                        if (row % 2 == 0) {
                            // en filas pares, empiezan con blanco en col 0
                            isBlack = (col % 2 == 1);
                        } else {
                            // en filas impares, empiezan con negro
                            isBlack = (col % 2 == 0);
                        }

                        for (int k = 0; k < n; k++) {
                            if (isBlack) {
                                System.out.print(blackChar);
                            } else {
                                System.out.print(" ");
                            }
                        }
                    }
                    System.out.println("|");
                }
            }

            // línea inferior
            System.out.print("|");
            for (int i = 0; i < totalSize; i++) {
                System.out.print("-");
            }
            System.out.println("|");
        }
    }
}

