package E310CuentaBancaria;

public class Cuenta implements Cloneable {
    // Representamos el saldo en céntimos usando int
    private int saldoEnCentimos;
    // Representamos el descubierto máximo en céntimos usando int
    private int descubiertoMaximoEnCentimos;

    // Constructor para crear una cuenta sin descubierto
    public Cuenta(double saldoInicial) {
        // Convertimos euros a céntimos usando Math.round para mayor precisión
        this.saldoEnCentimos = (int) Math.round(saldoInicial * 100);
        // Sin descubierto, por lo tanto 0 céntimos
        this.descubiertoMaximoEnCentimos = 0;
    }

    // Constructor para crear una cuenta con descubierto
    public Cuenta(double saldoInicial, double descubiertoMaximo) {
        // Convertimos euros a céntimos
        this.saldoEnCentimos = (int) Math.round(saldoInicial * 100);
        // Convertimos el descubierto máximo de euros a céntimos
        this.descubiertoMaximoEnCentimos = (int) Math.round(descubiertoMaximo * 100);
    }

    // Método para ingresar dinero desde un cajero
    public void ingresarCajero(double cantidad) {
        // Convertimos la cantidad de euros a céntimos y la sumamos al saldo
        saldoEnCentimos += (int) Math.round(cantidad * 100);
    }

    // Método para extraer dinero desde un cajero (NO permite quedarse en negativo)
    public void extraerCajero(double cantidad) {
        // Convertimos la cantidad de euros a céntimos
        int cantidadEnCentimos = (int) Math.round(cantidad * 100);
        // Verificamos si la extracción dejaría el saldo negativo
        if (saldoEnCentimos - cantidadEnCentimos < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }
        // Si no hay problema, restamos la cantidad
        saldoEnCentimos -= cantidadEnCentimos;
    }

    // Método para cargar un recibo (permite descubierto si está configurado)
    public void cargarRecibo(double cantidad) {
        // Convertimos la cantidad de euros a céntimos
        int cantidadEnCentimos = (int) Math.round(cantidad * 100);
        // Verificamos si la carga superaría el descubierto máximo permitido
        if (saldoEnCentimos - cantidadEnCentimos < -descubiertoMaximoEnCentimos) {
            throw new RuntimeException("Descubierto máximo superado");
        }
        // Si no supera el límite, restamos la cantidad
        saldoEnCentimos -= cantidadEnCentimos;
    }

    // Método para obtener una representación en texto de la cuenta
    public String toString() {
        // Convertimos céntimos a euros para mostrar al usuario
        double saldoEuros = saldoEnCentimos / 100.0;
        double descubiertoEuros = descubiertoMaximoEnCentimos / 100.0;
        return "Saldo: " + saldoEuros + " €, Descubierto máximo: " + descubiertoEuros + " €";
    }

    // Método para comparar si dos cuentas son iguales (solo compara el saldo)
    public boolean equals(Object obj) {
        // Si son el mismo objeto, son iguales
        if (this == obj) return true;
        // Si el objeto no es de tipo Cuenta, no son iguales
        if (!(obj instanceof Cuenta)) return false;

        // Convertimos el objeto a tipo Cuenta
        Cuenta otra = (Cuenta) obj;
        // Comparamos los saldos en céntimos
        return this.saldoEnCentimos == otra.saldoEnCentimos;
    }

    // Método para crear una copia de la cuenta
    public Cuenta clone() {
        try {
            // Usamos el clone de Object que hace copia superficial
            return (Cuenta) super.clone();
        } catch (CloneNotSupportedException e) {
            // Esto no debería ocurrir ya que implementamos Cloneable
            return null;
        }
    }
}