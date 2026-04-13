import java.util.Scanner;

public class E970JardinesAlhambra769 {
    static void inundar(char[][] mapa, int fila, int columna) {
        if (fila < 0 || fila == mapa.length || columna < 0 || columna == mapa[fila].length || mapa[fila][columna] != '#') {
            return;
        }

        mapa[fila][columna] = '.';

        inundar(mapa, fila + 1, columna);
        inundar(mapa, fila - 1, columna);
        inundar(mapa, fila, columna + 1);
        inundar(mapa, fila, columna - 1);
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while (teclado.hasNext()) {
            int filas = teclado.nextInt();
            int columnas = teclado.nextInt();
            char[][] mapa = new char[filas][columnas];

            teclado.nextLine();
            for (int i = 0; i < filas; i++) {
                char[] linea = teclado.nextLine().toCharArray();
                for (int j = 0; j < columnas; j++) {
                    mapa[i][j] = linea[j];
                }
            }

            int contadorCesped = 0;
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (mapa[i][j] == '#') {
                        contadorCesped++;
                        inundar(mapa, i, j);
                    }
                }
            }
            System.out.println(contadorCesped);
        }
    }
}
