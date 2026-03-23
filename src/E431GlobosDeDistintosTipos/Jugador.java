package b400ooavanzada.E430GlobosConJugadoresMixtos;

public abstract class Jugador implements Comparable<Jugador> {
    protected static final int SOPLO_MINIMO = 1;
    protected static final int SOPLO_MAXIMO = 10;

    protected String nombre;
    protected int vidas;
    protected int soplidos = 0;

    public Jugador(String nombre, int vidas) {
        setNombre(nombre);
        setVidas(vidas);
    }

    public String toString() {
        return String.format("%s %s (%dv %ds)",
                getClass().getSimpleName(),
                getNombre(),
                getVidas(),
                getSoplidos()
        );
    }

    public int compareTo(Jugador otro) {
        return (1000000*this.getVidas() + this.getSoplidos()) - (1000000*otro.getVidas() + otro.getSoplidos());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getSoplidos() {
        return soplidos;
    }

    public void setSoplidos(int soplidos) {
        this.soplidos = soplidos;
    }

    public abstract int determinarSoplo();

    public void soplar(Globo globo) {
        int soplo = determinarSoplo();
        globo.inflar(soplo);
        soplidos++;
        System.out.printf("\n%s sopla %d\n", this, soplo);
    }

    public void quitarUnaVida() {
        if (!estaVivo()) throw new RuntimeException("No podemos descontar una vida a un jugador que ya no está vivo.");

        setVidas(getVidas() - 1);
    }

    public boolean estaVivo() {
        return getVidas() > 0;
    }
}