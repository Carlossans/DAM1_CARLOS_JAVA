package E312CuentaBancariaConInt;

public class Cuenta implements Cloneable {
    private int saldoEnCentimos;
    private int descubiertoMaximoEnCentimos;

    public int convertirACentimos(double num) {
        return (int) Math.round(num * 100) ;
    }

    public double convertirAEuros(int num) {
        return num / 100.0;
    }

    public Cuenta(double saldoInicial) {
        this.saldoEnCentimos = convertirACentimos(saldoInicial);
        this.descubiertoMaximoEnCentimos = 0;
    }

    public Cuenta(double saldoInicial, double descubiertoMaximo) {
        this.saldoEnCentimos = convertirACentimos(saldoInicial);
        this.descubiertoMaximoEnCentimos = convertirACentimos(descubiertoMaximo);
    }

    public void ingresarCajero(double cantidad) {
        saldoEnCentimos += convertirACentimos(cantidad);
    }

    public void extraerCajero(double cantidad) {
        int cantidadEnCentimos = convertirACentimos(cantidad);
        if (saldoEnCentimos - cantidadEnCentimos < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }
        saldoEnCentimos -= cantidadEnCentimos;
    }

    public void cargarRecibo(double cantidad) {
        int cantidadEnCentimos = convertirACentimos(cantidad);
        if (saldoEnCentimos - cantidadEnCentimos < -descubiertoMaximoEnCentimos) {
            throw new RuntimeException("Descubierto máximo superado");
        }
        saldoEnCentimos -= cantidadEnCentimos;
    }

    public String toString() {
        double saldoEuros = convertirAEuros(saldoEnCentimos);
        double descubiertoEuros = convertirAEuros(descubiertoMaximoEnCentimos);
        return "Saldo: " + saldoEuros + " €, Descubierto máximo: " + descubiertoEuros + " €";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cuenta)) return false;

        Cuenta otra = (Cuenta) obj;
        return this.saldoEnCentimos == otra.saldoEnCentimos;
    }

    public Cuenta clone() {
        try {
            return (Cuenta) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}