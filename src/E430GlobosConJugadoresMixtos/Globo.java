package E430GlobosConJugadoresMixtos;

public class Globo {
    private int capacidadMax;
    private int aireActual;

    public Globo() {
        this.capacidadMax = generarNumeroAleatorio(1, 50);
        this.aireActual = 0;
    }

    public Globo(int capacidadMax) {
        this.capacidadMax = capacidadMax;
        this.aireActual = 0;
    }

    private int generarNumeroAleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public void inflar(int cantidad) {
        this.aireActual += cantidad;
    }

    public boolean haExplotado() {
        return aireActual > capacidadMax;
    }

    public void mostrarGrafico() {
        System.out.println("\n    _______");
        System.out.println("   /       \\");
        System.out.println("  |  " + getRepresentacionVisual() + "  |");
        System.out.println("   \\_______/");
        System.out.println("      | |");
        System.out.println("   " + aireActual + "/" + capacidadMax + " unidades");
    }

    private String getRepresentacionVisual() {
        int totalCaracteres = 10;
        int caracteresLlenos = (int) ((double) aireActual / capacidadMax * totalCaracteres);

        if (caracteresLlenos > totalCaracteres) {
            caracteresLlenos = totalCaracteres;
        }
        int caracteresVacios = totalCaracteres - caracteresLlenos;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < caracteresLlenos; i++) {
            sb.append("*");
        }
        for (int i = 0; i < caracteresVacios; i++) {
            sb.append("·");
        }
        return sb.toString();
    }

    public void mostrarExplosion() {
        System.out.println("\n    **BOOM**");
        System.out.println("   *   |   *");
        System.out.println("  *    |    *");
        System.out.println("   *   |   *");
        System.out.println("    **BOOM**");
        System.out.println("¡EL GLOBO HA EXPLOTADO!");
        System.out.println("Capacidad máxima era: " + capacidadMax + " unidades");
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public int getAireActual() {
        return aireActual;
    }

    @Override
    public String toString() {
        return "Globo [capacidad=" + capacidadMax + ", aire=" + aireActual + ", explotado=" + haExplotado() + "]";
    }
}
