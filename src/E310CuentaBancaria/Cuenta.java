package E310CuentaBancaria;

public class Cuenta implements Cloneable {
    private int saldoEnCentimos;
    private int descubiertoMaximoEnCentimos;

    // Constructor para crear una cuenta sin descubierto
    public Cuenta(double saldoInicial) {
        this.saldoEnCentimos = (int) Math.round(saldoInicial * 100);
        this.descubiertoMaximoEnCentimos = 0;
    }

    // Constructor para crear una cuenta con descubierto
    public Cuenta(double saldoInicial, double descubiertoMaximo) {
        this.saldoEnCentimos = (int) Math.round(saldoInicial * 100);
        // Convertimos el descubierto máximo de euros a céntimos
        this.descubiertoMaximoEnCentimos = (int) Math.round(descubiertoMaximo * 100);
    }

    // Método para ingresar dinero desde un cajero
    public void ingresarCajero(double cantidad) {
        // Convertimos la cantidad de euros a céntimos y la sumamos al saldo
        saldoEnCentimos = saldoEnCentimos + (int) Math.round(cantidad * 100);
    }

    // Método para extraer dinero desde un cajero (NO permite quedarse en negativo)
    public void extraerCajero(double cantidad) {
        int cantidadEnCentimos = (int) Math.round(cantidad * 100);
        // Verificamos si la extracción dejaría el saldo negativo
        if (saldoEnCentimos - cantidadEnCentimos < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }
        saldoEnCentimos -= cantidadEnCentimos;
    }

    // Método para cargar un recibo (permite descubierto si está configurado)
    public void cargarRecibo(double cantidad) {
        int cantidadEnCentimos = (int) Math.round(cantidad * 100);
        // Verificamos si la carga superaría el descubierto máximo permitido
        if (saldoEnCentimos - cantidadEnCentimos < -descubiertoMaximoEnCentimos) {
            throw new RuntimeException("Descubierto máximo superado");
        }

        saldoEnCentimos -= cantidadEnCentimos;
    }

    // Método para obtener una representación en texto de la cuenta
    public String toString() {
        // céntimos a euros
        double saldoEuros = saldoEnCentimos / 100.0;
        double descubiertoEuros = descubiertoMaximoEnCentimos / 100.0;
        return "Saldo: " + saldoEuros + " €, Descubierto máximo: " + descubiertoEuros + " €";
    }

    // Método para comparar si dos cuentas son iguales (solo compara el saldo)
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cuenta)) return false;

        // Convertimos el objeto a tipo Cuenta
        Cuenta otra = (Cuenta) obj;
        // Comparamos los saldos en céntimos
        return this.saldoEnCentimos == otra.saldoEnCentimos;
    }

    // Método para crear una copia de la cuenta
    public Cuenta clone() {
        try {
            return (Cuenta) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}