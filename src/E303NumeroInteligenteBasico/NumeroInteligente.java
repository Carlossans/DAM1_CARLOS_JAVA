package E303NumeroInteligenteBasico;

public class NumeroInteligente {
    private int valor;

    public NumeroInteligente() {
        valor = 1;
    }

    public NumeroInteligente(int numero) {
        this.valor = numero;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int numero) {
        this.valor = numero;
    }

    public void incrementar() {
        valor++;
    }

    public void incrementar(int numero) {
        valor += numero;
    }

    public void decrementar(int numero) {
        valor -= numero;
    }

    public void decrementar() {
        valor--;
    }

    public boolean esPrimo() {
        if (valor <= 1) {
            return false;
        }
        for (int i = 2; i < valor; i++) {
            if (valor % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean esPerfecto() {
        int suma = 0;
        for (int i = 1; i < valor; i++) {
            if (valor % i == 0) {
                suma += i;
            }
        }
        if (suma == valor) {
            return true;
        } else {
            return false;
        }
    }
}
