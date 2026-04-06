package b400OOAVANZADA.b40000avanzada.Animales.HundirLaFlota;

public class Tablero {
    private Barco[] barcos = new Barco[5];
    private boolean[][] tirosRecibidos = new boolean[10][10];
    private int barcosColocados = 0;

    public void agregarBarco(Barco b) {
        if (barcosColocados < 5) {
            barcos[barcosColocados] = b;
            barcosColocados = barcosColocados + 1;
        }
    }

    public boolean hayBarcoEnPosicion(int f, int c) {
        for (int i = 0; i < barcosColocados; i = i + 1) {
            Barco b = barcos[i];
            for (int j = 0; j < b.getTamanno(); j = j + 1) {
                int bf;
                int bc;
                if (b.isVertical()) {
                    bf = b.getFil() + j;
                    bc = b.getCol();
                } else {
                    bf = b.getFil();
                    bc = b.getCol() + j;
                }
                if (bf == f && bc == c) {
                    return true;
                }
            }
        }
        return false;
    }

    public ResultadoDisparo recibirDisparo(int fil, int col) {
        tirosRecibidos[fil][col] = true;
        for (int i = 0; i < barcosColocados; i = i + 1) {
            if (barcos[i].disparar(fil, col)) {
                if (barcos[i].hundido()) {
                    return ResultadoDisparo.HUNDIDO;
                }
                return ResultadoDisparo.TOCADO;
            }
        }
        return ResultadoDisparo.AGUA;
    }

    public boolean estaTodoHundido() {
        for (int i = 0; i < barcosColocados; i = i + 1) {
            if (barcos[i].hundido() == false) {
                return false;
            }
        }
        return true;
    }
}