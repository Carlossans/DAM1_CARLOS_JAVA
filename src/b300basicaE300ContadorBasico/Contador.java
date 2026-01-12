package b300basicaE300ContadorBasico;

public class Contador {
    private static final int MIN = 0;
    private static final int MAX = 100;

    private int valor = MIN;
    private String etiqueta;

    public Contador(int valorInicial) {

    }

    public int getValor() {
        return valor;
    }

    public void setValor(int nuevoValor) {
        if      (nuevoValor < MIN) valor = MIN;
        else if (nuevoValor > MAX) valor = MAX;
        else                       valor = nuevoValor;

        // Alternativa más corta pero más críptica (no mola):
        // valor = Math.min(Math.max(nuevoValor, MIN), MAX);
    }

    public void incrementar() {
        setValor(valor+1);
    }

    public void decrementar() {
        setValor(valor-1);
    }
}
