package E430GlobosConJugadoresMixtos;

public class JugadorCpu extends Jugador {

    public JugadorCpu(String nombre) {
        super(nombre);
    }

    @Override
    public int determinarSoplo() {
        int maxSoplo = calcularSoplidoMaximo();

        int soplo = (int) (Math.random() * (maxSoplo - MIN_SOPLO + 1)) + MIN_SOPLO;

        System.out.println("\n--- Turno de " + nombre + " (CPU) ---");
        System.out.println("Aire total soplado en la partida: " + aireTotalSoplado);
        if (soploAnterior > 0) {
            System.out.println("Sopló " + soploAnterior + " en su turno anterior.");
            System.out.println("Está cansado: máximo puede soplar " + maxSoplo + " unidades.");
        }
        System.out.println(nombre + " decide soplar " + soplo + " unidades de aire.");

        return soplo;
    }
}
