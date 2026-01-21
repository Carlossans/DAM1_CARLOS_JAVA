package b300basicaE300ContadorBasico;

public class Contador {
    private static final int MIN = 0;
    private static final int MAX = 100;
    private static final String ETIQUETA_POR_DEFECTO = " unidades";

    private int valor = MIN;
    private String etiqueta;
    private int paso = 1;
    private boolean redondeo = false;

    public Contador() {
        this(50, 1, false);
        this.valor = MIN;
        this.etiqueta = ETIQUETA_POR_DEFECTO;
    }

    public Contador(int valorInicial) {
        this(valorInicial, 1, false);
    }

    public Contador(int valorInicial, int paso) {
        this(valorInicial, paso, false);
    }

    public Contador(int valorInicial, int paso, boolean redondeo) { // este nose como se hace
        this.paso = (paso <= 0) ? 1 : paso;
        this.redondeo = redondeo;

        if (redondeo) {
            valorInicial = (valorInicial / this.paso) * this.paso;
        }

        setValor(valorInicial);
        this.etiqueta = ETIQUETA_POR_DEFECTO;
    }

    // public Contador(int valorInicial, String etiqueta) {
    //     setValor(valorInicial);
    //     this.etiqueta = (etiqueta == null || etiqueta.trim().isEmpty()) ?
    //             ETIQUETA_POR_DEFECTO : etiqueta;
    // }

    public int getValor() {
        return valor;
    }

    public void setValor(int nuevoValor) {
        if (nuevoValor < MIN) {
            valor = MIN;
        } else if (nuevoValor > MAX) {
            valor = MAX;
        } else {
            valor = nuevoValor;
        }
    }

    public int getPaso() {
        return paso;
    }

    public void setPaso(int paso) {
        if (paso > 0) {
            this.paso = paso;
        }
    }

    public boolean isRedondeo() {
        return redondeo;
    }

    public void setRedondeo(boolean redondeo) {
        this.redondeo = redondeo;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = (etiqueta == null || etiqueta.trim().isEmpty()) ? ETIQUETA_POR_DEFECTO : etiqueta;
    }

    public void resetear() {
        this.valor = MIN;
    }

    public void incrementar() {
        setValor(valor + paso);
    }

    public void incrementar(int cantidad) {
        setValor(valor + cantidad);
    }

    public void decrementar() {
        setValor(valor - paso);
    }

    public void decrementar(int cantidad) {
        setValor(valor - cantidad);
    }

    // toString para representación automática
    @Override
    public String toString() {
        return valor + etiqueta;
    }
}
