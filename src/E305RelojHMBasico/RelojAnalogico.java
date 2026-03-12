package E305RelojHMBasico;

public class RelojAnalogico extends Reloj {

    public RelojAnalogico(int h, int m) { super(h, m); }

    public String toString() {
        // 1. Crear el "lienzo" del reloj (matriz 5x5)
        String[][] r = {
                {" ", "23", "12", "13", " "},
                {"22", " ", " ", " ", "14"},
                {"21", " ", "·", " ", "15"},
                {"20", " ", " ", " ", "16"},
                {" ", "19", "18", "17", " "}
        };

        // 2. Obtener la hora en formato 12h para la manecilla horaria
        int hora = getH() % 12;
        if (hora == 0) hora = 12;

        // 3. DIBUJAR LA MANECILLA HORARIA
        //    Según la hora, se modifican dos posiciones específicas de la matriz
        //    para que apunten en la dirección correcta.
        switch (hora) {
            case 12: // Hacia arriba
                r[1][2] = "|";
                r[0][2] = "|";
                break;
            case 1:  // Hacia arriba-derecha
                r[1][3] = "/";
                r[0][4] = "/";
                break;
            case 2, 3: // Hacia la derecha
                r[2][3] = "-";
                r[2][4] = "-";
                break;
            case 4:  // Hacia abajo-derecha
                r[3][3] = "\\";
                r[4][4] = "\\";
                break;
            case 5, 6: // Hacia abajo
                r[3][2] = "|";
                r[4][2] = "|";
                break;
            case 7:  // Hacia abajo-izquierda
                r[3][1] = "/";
                r[4][0] = "/";
                break;
            case 8, 9: // Hacia la izquierda
                r[2][1] = "-";
                r[2][0] = "-";
                break;
            case 10: // Hacia arriba-izquierda
                r[1][1] = "\\";
                r[0][0] = "\\";
                break;
            case 11: // Hacia arriba
                r[1][2] = "|";
                r[0][2] = "|";
                break;
        }

        // 4. CONSTRUIR EL STRING DE SALIDA
        String s = "";
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r[i].length; j++) {
                s += r[i][j] + " "; // Añade un espacio entre caracteres
            }
            s += "\n"; // Salto de línea al final de cada fila
        }

        return s;
    }
}