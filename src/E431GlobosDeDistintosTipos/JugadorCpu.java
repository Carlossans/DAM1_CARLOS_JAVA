package E431GlobosDeDistintosTipos;

import java.util.Random;

public class JugadorCpu extends Jugador {
    private Random random = new Random();

    public JugadorCpu(String nombre, int vidas) {
        super(nombre, vidas);
    }

    public int determinarSoplo() {
        return random.nextInt(SOPLO_MINIMO, SOPLO_MAXIMO+1);
    }
}