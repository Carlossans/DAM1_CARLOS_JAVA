package E310CuentaBancaria;

public class Principal {
    // Método principal donde probamos la funcionalidad de la clase Cuenta
    public static void main(String[] args) {
        // Creamos una cuenta sin descubierto con saldo inicial de 100€
        Cuenta cuentaSinDescubierto = new Cuenta(100);
        // Creamos una cuenta con descubierto de 70€ y saldo inicial de 100€
        Cuenta cuentaConDescubierto = new Cuenta(100, 70);

        // Mostramos el estado inicial de ambas cuentas
        System.out.println("Cuenta sin descubierto: " + cuentaSinDescubierto);
        System.out.println("Cuenta con descubierto: " + cuentaConDescubierto);

        // Probamos a ingresar 50€ en la cuenta sin descubierto
        cuentaSinDescubierto.ingresarCajero(50);
        System.out.println("Después de ingresar 50€: " + cuentaSinDescubierto);

        // Probamos a extraer 150€ de la cuenta sin descubierto
        cuentaSinDescubierto.extraerCajero(150);
        System.out.println("Después de extraer 150€: " + cuentaSinDescubierto);

        // Probamos a cargar un recibo de 150€ en la cuenta con descubierto
        cuentaConDescubierto.cargarRecibo(150);
        System.out.println("Después de cargar recibo de 150€: " + cuentaConDescubierto);

        // Comparamos si las dos cuentas tienen el mismo saldo
        System.out.println("¿Las cuentas son iguales? " +
                cuentaSinDescubierto.equals(cuentaConDescubierto));

        // Clonamos la cuenta con descubierto
        Cuenta copiaCuenta = cuentaConDescubierto.clone();
        System.out.println("Cuenta clonada: " + copiaCuenta);

        // Intentamos extraer 10€ de la cuenta sin descubierto (debería fallar)
        try {
            cuentaSinDescubierto.extraerCajero(10);
        } catch (RuntimeException e) {
            System.out.println("Error al extraer: " + e.getMessage());
        }

        // Intentamos cargar un recibo de 50€ en la cuenta con descubierto (debería fallar)
        try {
            cuentaConDescubierto.cargarRecibo(50);
        } catch (RuntimeException e) {
            System.out.println("Error al cargar recibo: " + e.getMessage());
        }
    }
}