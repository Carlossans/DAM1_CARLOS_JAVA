package practica_pmd;

public class Pruebas {

    public Pruebas() {

    }
    public int sumar(final int numero1, final int numero2) {
        return numero1 + numero2;
    }

    public void noHaceNada() {
        // Este método no hace nada
    }

    public void preguntaVacia(final int valor) {
        System.out.println("Valor de a: " + valor);

        if (valor > 0) {
            System.out.println("\n");
        }
    }

    public void bloquetrycatchvacio() {
        final int result;
        try {
            result = 10 / 0;
        } catch (RuntimeExceptionException e) {
            throw new RuntimeException(String.valueOf(e));
            // Bloque catch vacío
        }
        System.out.println(result);
    }
}
