package E305RelojHMBasico;

public class RelojDigital extends Reloj{

    public String toString() {
        return String.format("%02d:%02d", getH(), getM());
    }
}
