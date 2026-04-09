package E861ExcepcionesEnReloj;

public class OperacionNegativaRelojException extends Exception {
    public OperacionNegativaRelojException() {
        super("No se permiten operaciones con valores negativos.");
    }
}