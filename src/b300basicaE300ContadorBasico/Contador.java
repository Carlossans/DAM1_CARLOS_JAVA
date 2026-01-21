package b300basicaE300ContadorBasico;

public class Contador {
    private static final int MIN = 0;
    private static final int MAX = 100;
    private static final String ETIQUETA_POR_DEFECTO = " unidades";

    private int valor = MIN;
    private String etiqueta;

    public Contador() {
        this.valor = MIN;
        this.etiqueta = ETIQUETA_POR_DEFECTO;
    }

    public Contador(int valorInicial) {
        setValor(valorInicial);
        this.etiqueta = ETIQUETA_POR_DEFECTO;
    }

    public Contador(int valorInicial, String etiqueta) {
        setValor(valorInicial);
        this.etiqueta = (etiqueta == null || etiqueta.trim().isEmpty()) ?
                ETIQUETA_POR_DEFECTO : etiqueta;
    }

    public Contador(int valorInicial, int paso) {
        setValor(valorInicial + paso);
        this.etiqueta = (etiqueta == null || etiqueta.trim().isEmpty()) ?
                ETIQUETA_POR_DEFECTO : etiqueta;
    }

    public Contador(int valorInicial, int paso, boolean redondeo) { // este nose como se hace

        if (redondeo == true) {
            int incrementoRedondeo = this.valor % 100;
            setValor(valorInicial + paso + incrementoRedondeo);
            this.etiqueta = (etiqueta == null || etiqueta.trim().isEmpty()) ?
                    ETIQUETA_POR_DEFECTO : etiqueta;
        }

        setValor(valorInicial + paso);
        this.etiqueta = (etiqueta == null || etiqueta.trim().isEmpty()) ?
                ETIQUETA_POR_DEFECTO : etiqueta;
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

//    public String getEtiqueta() {
//        return etiqueta;
//    }
//
//    public void setEtiqueta(String etiqueta) {
//        this.etiqueta = (etiqueta == null || etiqueta.trim().isEmpty()) ?
//                ETIQUETA_POR_DEFECTO : etiqueta;
//    }
//
//    public void resetear() {
//        this.valor = MIN;
//    }
//
//    public void incrementar() {
//        setValor(valor + 1);
//    }
//
//    public void incrementar(int cantidad) {
//        setValor(valor + cantidad);
//    }
//
//    public void decrementar() {
//        setValor(valor - 1);
//    }
//
//    public void decrementar(int cantidad) {
//        setValor(valor - cantidad);
//    }
//
    // toString para representación automática
    @Override
    public String toString() {
        return valor + etiqueta;
    }
}
