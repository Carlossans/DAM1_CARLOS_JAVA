package E310CuentaBancaria;

public class Principal {

    public static void main(String[] args) {

        // Crear cuentas
        Cuenta cuentaSinDescubierto = new Cuenta(100);
        Cuenta cuentaConDescubierto = new Cuenta(100, 70);

        // Mostrar cuentas
        System.out.println("Cuenta sin descubierto: " + cuentaSinDescubierto);
        System.out.println("Cuenta con descubierto: " + cuentaConDescubierto);

        // Probar ingresar dinero
        cuentaSinDescubierto.ingresarCajero(50);
        System.out.println("Después de ingresar 50€: " + cuentaSinDescubierto);

        // Probar extraer dinero hasta llegar a 0
        cuentaSinDescubierto.extraerCajero(150);
        System.out.println("Después de extraer 150€: " + cuentaSinDescubierto);

        // Probar cargar recibos con descubierto
        cuentaConDescubierto.cargarRecibo(150);
        System.out.println("Después de cargar recibo de 150€: " + cuentaConDescubierto);

        // Probar equals
        System.out.println("¿Las cuentas son iguales? " +
                cuentaSinDescubierto.equals(cuentaConDescubierto));

        // Probar clone
        Cuenta copiaCuenta = cuentaConDescubierto.clone();
        System.out.println("Cuenta clonada: " + copiaCuenta);

        // Probar error por extraer dejando saldo negativo
        try {
            cuentaSinDescubierto.extraerCajero(10);
        } catch (RuntimeException e) {
            System.out.println("Error al extraer: " + e.getMessage());
        }

        // Probar error por superar descubierto
        try {
            cuentaConDescubierto.cargarRecibo(50);
        } catch (RuntimeException e) {
            System.out.println("Error al cargar recibo: " + e.getMessage());
        }
    }
}

