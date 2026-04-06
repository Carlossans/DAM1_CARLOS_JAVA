package E432GlobosConStrategy;

import java.util.Random;

public abstract class Globo {
    public static final int RANDOM_MIN = 10;
    public static final int RANDOM_MAX = 50;

    protected Random random = new Random();
    protected int capacidad;
    protected int aire = 0;
    protected boolean explotado = false;

    public Globo() {
        this.capacidad = random.nextInt(RANDOM_MIN, RANDOM_MAX+1);
    }

    public Globo(int valor) {
        capacidad = valor;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getAire() {
        return aire;
    }

    protected void setAire(int aire) {
        this.aire = aire;
    }

    protected void marcarExplotado() {
        this.explotado = true;
    }

    public String toString() {
        StringBuilder cadena = new StringBuilder();

        for (int i = 0; (i < aire) && (i < capacidad); i++) {
            cadena.append("*");
        }
        for (int i = aire; i < capacidad; i++) {
            cadena.append("O");
        }
        for (int i = capacidad; i < aire; i++) {
            cadena.append("!");
        }

        return cadena.toString();
    }

    public abstract void inflar(int cantidad);

    public abstract boolean explotado();
}
