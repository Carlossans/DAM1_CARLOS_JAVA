package OPCIONALES;

public class Proyectil {
    private static final double GRAVEDAD_NIVEL_MAR = -9.81;
    private static final double RADIO_TIERRA = 6371000.0;

    private double altura;
    private double velocidad;

    public Proyectil(double velocidadInicial) {
        this.velocidad = velocidadInicial;
        this.altura = 0.0;
    }

    public double getAltura() {
        return altura;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void actualizar(double deltaTiempo) {
        // Cálculo de la gravedad variable según la altura actual
        double gravedadActual = GRAVEDAD_NIVEL_MAR * Math.pow(RADIO_TIERRA / (RADIO_TIERRA + altura), 2);

        // Actualización de velocidad y posición sin usar operadores combinados
        velocidad = velocidad + (gravedadActual * deltaTiempo);
        altura = altura + (velocidad * deltaTiempo);
    }
}