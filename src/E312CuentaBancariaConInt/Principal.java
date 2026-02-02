package E312CuentaBancariaConInt;

public class Principal {
    public static void main(String[] args) {
        Cuenta cuentaSinDescubierto = new Cuenta(100);
        Cuenta cuentaConDescubierto = new Cuenta(100, 70);

        System.out.println("Cuenta sin descubierto: " + cuentaSinDescubierto);
        System.out.println("Cuenta con descubierto: " + cuentaConDescubierto);

        cuentaSinDescubierto.ingresarCajero(50);
        System.out.println("Después de ingresar 50€: " + cuentaSinDescubierto);

        cuentaSinDescubierto.extraerCajero(150);
        System.out.println("Después de extraer 150€: " + cuentaSinDescubierto);

        cuentaConDescubierto.cargarRecibo(150);
        System.out.println("Después de cargar recibo de 150€: " + cuentaConDescubierto);

        System.out.println("¿Las cuentas son iguales? " +
                cuentaSinDescubierto.equals(cuentaConDescubierto));

        Cuenta copiaCuenta = cuentaConDescubierto.clone();
        System.out.println("Cuenta clonada: " + copiaCuenta);

        try {
            cuentaSinDescubierto.extraerCajero(10);
        } catch (RuntimeException e) {
            System.out.println("Error al extraer: " + e.getMessage());
        }

        try {
            cuentaConDescubierto.cargarRecibo(50);
        } catch (RuntimeException e) {
            System.out.println("Error al cargar recibo: " + e.getMessage());
        }
    }
}