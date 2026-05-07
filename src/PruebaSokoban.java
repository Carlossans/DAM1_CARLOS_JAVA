import java.util.Scanner;

public class PruebaSokoban {

    public static char[][] convertirAMatriz(String nivelTexto) {
        // Separamos el string por saltos de línea.
        // "\\r?\\n" asegura compatibilidad tanto con Windows (\r\n) como con Linux/Mac (\n).
        String[] lineas = nivelTexto.split("\\r?\\n");

        // Inicializamos la matriz con el número de filas (lineas.length)
        char[][] matriz = new char[lineas.length][];

        // Rellenamos cada fila
        for (int i = 0; i < lineas.length; i++) {
            // toCharArray() convierte el String directamente en un char[]
            matriz[i] = lineas[i].toCharArray();
        }

        return matriz;
    }

    public static void imprimirMapa(char[][] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.print(mapa[i][j]);
            }
            System.out.println(); // Salto de línea al terminar la fila
        }
    }

    public static void main(String[] args) {

        String nivelSokoban = """
                ###############
                #             #
                #   #######   #
                #   #     #   #
                #   #  $  #   #
                #   #   @ #   #
                #   ### ###   #
                #     # #     #
                #   #.$ $ #   #
                #   # . . #   #
                #   #######   #
                #             #
                #             #
                #             #
                ###############
                """;

        // 2. Convertimos el String a la matriz bidimensional
        char[][] mapa = convertirAMatriz(nivelSokoban);

        int fJugador = -1, cJugador = -1;
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j] == '@') {
                    fJugador = i;
                    cJugador = j;
                }
            }
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            imprimirMapa(mapa);
            System.out.print("Mover (WASD): ");
            char movimiento = sc.next().toLowerCase().charAt(0);

            int nuevaF = fJugador;
            int nuevaC = cJugador;

            if (movimiento == 'w') nuevaF--;
            else if (movimiento == 's') nuevaF++;
            else if (movimiento == 'a') nuevaC--;
            else if (movimiento == 'd') nuevaC++;

            if (mapa[nuevaF][nuevaC] != '#') {

                mapa[fJugador][cJugador] = ' ';
                fJugador = nuevaF;
                cJugador = nuevaC;
                mapa[fJugador][cJugador] = '@';
            } else {
                System.out.println("¡PAM! Chocaste con una pared.");
            }
        }
    }
}