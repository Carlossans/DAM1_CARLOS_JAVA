package E861ExcepcionesEnReloj;

public class HoraNoValidaException extends Exception {
    public HoraNoValidaException(String mensaje) {
        super(mensaje);
    }
}