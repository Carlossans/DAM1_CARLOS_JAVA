package E305RelojHMBasico;

public class RelojAnalogico extends Reloj {

    public RelojAnalogico(int h, int m) {
        super(h, m);
    }

    public String toString() {

        char[][] r = {
                {' ', 'o', '|', 'o', ' '},
                {'o', ' ', ' ', ' ', 'o'},
                {'-', ' ', '·', ' ', '-'},
                {'o', ' ', ' ', ' ', 'o'},
                {' ', 'o', '|', 'o', ' '}
        };

        int hora = getH() % 12;
        if (hora == 0) hora = 12;

        switch (hora) {

            case 12:
                r[1][2] = '|';
                r[0][2] = '|';
                break;

            case 1:
                r[1][3] = '/';
                r[0][4] = '/';
                break;

            case 2, 3:
                r[2][3] = '-';
                r[2][4] = '-';
                break;

            case 4:
                r[3][3] = '\\';
                r[4][4] = '\\';
                break;

            case 5, 6:
                r[3][2] = '|';
                r[4][2] = '|';
                break;

            case 7:
                r[3][1] = '/';
                r[4][0] = '/';
                break;

            case 8, 9:
                r[2][1] = '-';
                r[2][0] = '-';
                break;

            case 10:
                r[1][1] = '\\';
                r[0][0] = '\\';
                break;

            case 11:
                r[1][2] = '|';
                r[0][2] = '|';
                break;
        }

        String s = "";

        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r[i].length; j++) {
                s += r[i][j] + " ";
            }
            s += "\n";
        }

        return s;
    }
}