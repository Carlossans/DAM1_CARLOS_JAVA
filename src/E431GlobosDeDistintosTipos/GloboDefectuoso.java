package E431GlobosDeDistintosTipos;

public class GloboDefectuoso extends Globo {
    private static final double UMBRAL_SEGURO = 0.6;

    public GloboDefectuoso() {
        super();
    }

    public GloboDefectuoso(int valor) {
        super(valor);
    }

    public void inflar(int cantidad) {
        setAire(getAire() + cantidad);
    }

    public boolean explotado() {
        if (explotado) {
            return true;
        }

        double porcentajeCapacidadNominal = (double) getAire() / getCapacidad();

        if (porcentajeCapacidadNominal <= UMBRAL_SEGURO) {
            return false;
        }

        if (porcentajeCapacidadNominal >= 1.0) {
            marcarExplotado();
            return true;
        }

        double porcentajeCaminoRestante = (porcentajeCapacidadNominal - UMBRAL_SEGURO) / 0.4;
        boolean explota = Math.random() < porcentajeCaminoRestante;

        if (explota) {
            marcarExplotado();
        }

        return explota;
    }
}
