package b301ContadorBasico;

public class contador implements Cloneable{
    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int VALOR_POR_DEFECTO = 50;

    private int valor;
    private String etiqueta;

    
    public contador() {
        resetear();
        setEtiqueta("unidades");
    }

    public contador(int valor, String etiqueta) {
        setValor(valor);
        setEtiqueta(etiqueta);
    }

    public String toString() {
        return getValor() + " llaves";
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        if      (valor <= MIN) this.valor = MIN;
        else if (valor >= MAX) this.valor = MAX;
        else                   this.valor = valor;

        // Alternativa más corta pero más críptica (no mola):
        // valor = Math.min(Math.max(nuevoValor, 0), 100);
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void resetear() {
        setValor(VALOR_POR_DEFECTO);
    }

    public void incrementar() {
        incrementar(1);
    }

    public void incrementar(int diferencia) {
        setValor(getValor() + diferencia);
    }

    public void decrementar() {
        decrementar(1);
    }

    public void decrementar(int diferencia) {
        setValor(valor - diferencia);
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
