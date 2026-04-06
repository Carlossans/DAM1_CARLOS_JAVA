package E432GlobosConStrategy;

public class GloboNormal extends Globo {

    public GloboNormal() {
        super();
    }

    public GloboNormal(int valor) {
        super(valor);
    }

    public void inflar(int cantidad) {
        setAire(getAire() + cantidad);
    }

    public boolean explotado() {
        return getAire() > getCapacidad();
    }
}
