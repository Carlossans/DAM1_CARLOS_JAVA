package b400OOAVANZADA.b40000avanzada.Animales.HundirLaFlota;

public class Barco {
    private Tablero tablero;
    private String denominacion;
    private int tamanno;
    private boolean[] disparos;
    private int cantidadImpactos;
    private int fil;
    private int col;
    private boolean vertical;

    public Barco(Tablero tablero, String denominacion, int tamanno) {
        this.tablero = tablero;
        this.denominacion = denominacion;
        this.tamanno = tamanno;
        this.disparos = new boolean[tamanno];
        this.cantidadImpactos = 0;
    }

    public boolean situar(int fil, int col, boolean vertical) {
        if (vertical) {
            if (fil + tamanno > 10) {
                return false;
            }
        } else {
            if (col + tamanno > 10) {
                return false;
            }
        }

        for (int i = -1; i <= tamanno; i = i + 1) {
            for (int j = -1; j <= 1; j = j + 1) {
                int fCheck;
                int cCheck;
                if (vertical) {
                    fCheck = fil + i;
                    cCheck = col + j;
                } else {
                    fCheck = fil + j;
                    cCheck = col + i;
                }

                if (fCheck >= 0 && fCheck < 10 && cCheck >= 0 && cCheck < 10) {
                    if (tablero.hayBarcoEnPosicion(fCheck, cCheck)) {
                        return false;
                    }
                }
            }
        }

        this.fil = fil;
        this.col = col;
        this.vertical = vertical;
        return true;
    }

    public boolean disparar(int fil, int col) {
        for (int i = 0; i < tamanno; i = i + 1) {
            int fBarco;
            int cBarco;
            if (vertical) {
                fBarco = this.fil + i;
                cBarco = this.col;
            } else {
                fBarco = this.fil;
                cBarco = this.col + i;
            }

            if (fBarco == fil && cBarco == col) {
                if (disparos[i] == false) {
                    disparos[i] = true;
                    cantidadImpactos = cantidadImpactos + 1;
                }
                return true;
            }
        }
        return false;
    }

    public boolean hundido() {
        return cantidadImpactos == tamanno;
    }

    public int getFil() { return fil; }
    public int getCol() { return col; }
    public int getTamanno() { return tamanno; }
    public boolean isVertical() { return vertical; }
}