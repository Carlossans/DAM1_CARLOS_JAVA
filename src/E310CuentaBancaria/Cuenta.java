package E310CuentaBancaria;

public class Cuenta implements Cloneable {

    // Atributos
    private double saldo;
    private double descubiertoMaximo; // en positivo (ej: 70 significa hasta -70)

    // Constructor sin descubierto
    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
        this.descubiertoMaximo = 0;
    }

    // Constructor con descubierto
    public Cuenta(double saldoInicial, double descubiertoMaximo) {
        this.saldo = saldoInicial;
        this.descubiertoMaximo = descubiertoMaximo;
    }

    // Ingresar dinero en el cajero
    public void ingresarCajero(double cantidad) {
        saldo += cantidad;
    }

    // Extraer dinero del cajero (NO permite negativos)
    public void extraerCajero(double cantidad) {
        if (saldo - cantidad < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }
        saldo -= cantidad;
    }

    // Cargar un recibo (permite descubierto si está configurado)
    public void cargarRecibo(double cantidad) {
        if (saldo - cantidad < -descubiertoMaximo) {
            throw new RuntimeException("Descubierto máximo superado");
        }
        saldo -= cantidad;
    }

    // toString
    public String toString() {
        return "Saldo: " + saldo + " €, Descubierto máximo: " + descubiertoMaximo + " €";
    }

    // equals: solo compara el saldo
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cuenta)) return false;

        Cuenta otra = (Cuenta) obj;
        return this.saldo == otra.saldo;
    }

    // clone
    public Cuenta clone() {
        try {
            return (Cuenta) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}


