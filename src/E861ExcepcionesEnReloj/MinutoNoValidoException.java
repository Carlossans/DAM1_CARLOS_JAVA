package E861ExcepcionesEnReloj;

public class MinutoNoValidoException extends Exception {
    public MinutoNoValidoException(String mensaje) {
        super(mensaje);
    }
}