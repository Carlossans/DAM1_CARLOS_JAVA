package b300basicaE300ContadorBasico;

public class Contador {

    private static final int MIN = 0;
    private static final int MAX = 100;
    private static final String ETIQUETA_POR_DEFECTO = " unidades";

    private int valor = 50;
    private String etiqueta;
    private int paso = 1;
    private boolean redondeo = false;

    public Contador() {
        this(50, 1, false);
    }

    public Contador(int valorInicial) {
        this(valorInicial, 1, false);
    }

    public Contador(int valorInicial, int paso) {
        this(valorInicial, paso, false);
    }

    public Contador(int valorInicial, int paso, boolean redondeo) {
        // Si el paso es menor o igual que 0, lo forzamos a 1
        this.paso = (paso <= 0) ? 1 : paso;

        // Guardamos si se quiere redondeo o no
        this.redondeo = redondeo;

        // Si el redondeo está activado, ajustamos el valor inicial
        // al múltiplo inferior más cercano del paso
        if (redondeo) {
            valorInicial = (valorInicial / this.paso) * this.paso;
        }

        setValor(valorInicial);

        this.etiqueta = ETIQUETA_POR_DEFECTO;
    }

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

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = (etiqueta == null || etiqueta.trim().isEmpty())
                ? ETIQUETA_POR_DEFECTO
                : etiqueta;
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

    @Override
    public String toString() {
        return valor + etiqueta;
    }
}
