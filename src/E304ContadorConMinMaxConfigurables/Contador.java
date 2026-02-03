package E304ContadorConMinMaxConfigurables;

public class Contador {
    private int minimo = 1;
    private int maximo = 100;
    private static final int VALOR_POR_DEFECTO = 50;
    
    private int valor;
    private String etiqueta;

    // CONSTRUCTOR 1: Sin parámetros - usa valores por defecto
    public Contador() {
        // Primero establecemos mínimo y máximo con valores por defecto (1 y 100)
        // Luego llamamos a resetear() que pondrá el valor a VALOR_POR_DEFECTO (50)
        resetear();
        setEtiqueta("unidades");
    }
    
    // CONSTRUCTOR 2: Con valor y etiqueta - mínimo y máximo por defecto
    public Contador(int valor, String etiqueta) {
        // Usamos los valores por defecto para mínimo y máximo
        setValor(valor);
        setEtiqueta(etiqueta);
    }
    
    // CONSTRUCTOR 3: NUEVO - Con valor, etiqueta, mínimo y máximo (todo configurable)
    public Contador(int valor, String etiqueta, int minimo, int maximo) {
        // Primero establecemos el mínimo y máximo
        setMinimo(minimo);
        setMaximo(maximo);
        // Luego establecemos el valor (que respetará el nuevo mínimo y máximo)
        setValor(valor);
        setEtiqueta(etiqueta);
    }
    
    // CONSTRUCTOR 4: NUEVO - Con etiqueta, mínimo y máximo (valor por defecto)
    public Contador(String etiqueta, int minimo, int maximo) {
        // Establecemos mínimo y máximo
        setMinimo(minimo);
        setMaximo(maximo);
        // Llamamos a resetear que pondrá el valor a VALOR_POR_DEFECTO
        resetear();
        setEtiqueta(etiqueta);
    }

    public String toString() {
        return getValor() + " " + etiqueta + " [min=" + minimo + ", max=" + maximo + "]";
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Contador)) return false;
        Contador otro = (Contador) obj;
        return this.valor == otro.valor && this.etiqueta.equals(otro.etiqueta) &&
               this.minimo == otro.minimo && this.maximo == otro.maximo;
    }

    public Contador clone() {
        // Ahora clonamos también los campos minimo y maximo
        Contador clon = new Contador(this.valor, this.etiqueta, this.minimo, this.maximo);
        return clon;
    }

    // GETTERS y SETTERS normales
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        // Ahora usa los campos minimo y maximo en lugar de constantes
        if (valor < minimo) this.valor = minimo;
        else if (valor > maximo) this.valor = maximo;
        else this.valor = valor;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
    
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    // NUEVOS GETTERS y SETTERS para minimo y maximo
    public int getMinimo() {
        return minimo;
    }
    
    public void setMinimo(int minimo) {
        // Validamos que el mínimo sea menor o igual que el máximo
        if (minimo <= maximo) {
            this.minimo = minimo;
            // Si cambiamos el mínimo, debemos verificar que el valor actual no sea menor
            if (valor < minimo) {
                valor = minimo;
            }
        }
        // Si mínimo > máximo, no hacemos nada (podríamos lanzar excepción)
    }
    
    public int getMaximo() {
        return maximo;
    }
    
    public void setMaximo(int maximo) {
        // Validamos que el máximo sea mayor o igual que el mínimo
        if (maximo >= minimo) {
            this.maximo = maximo;
            // Si cambiamos el máximo, debemos verificar que el valor actual no sea mayor
            if (valor > maximo) {
                valor = maximo;
            }
        }
        // Si máximo < mínimo, no hacemos nada (podríamos lanzar excepción)
    }

    public void resetear() {
        // Resetea al valor por defecto, pero respetando los límites actuales
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
}
