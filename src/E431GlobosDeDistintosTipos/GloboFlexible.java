package E431GlobosDeDistintosTipos;

public class GloboFlexible extends Globo {
    private static final double SOBRECAPACIDAD_PERMITIDA = 1.10;
    private int ultimoSoplo = 0;

    public GloboFlexible() {
        super();
    }

    public GloboFlexible(int valor) {
        super(valor);
    }

    public void inflar(int cantidad) {
        ultimoSoplo = cantidad;
        setAire(getAire() + cantidad);
    }

    public boolean explotado() {
        if (explotado) {
            return true;
        }

        double limiteFlexible = getCapacidad() * SOBRECAPACIDAD_PERMITIDA;
        int soploMaximo = (int) Math.ceil(getCapacidad() * 0.05);

        if (getAire() > getCapacidad() && ultimoSoplo > soploMaximo) {
            marcarExplotado();
            return true;
        }

        if (getAire() > limiteFlexible) {
            marcarExplotado();
            return true;
        }

        return false;
    }
}
