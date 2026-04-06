package OPCIONALES;

public class Principal {
    public static void main(String[] args) {
        double[] deltas = {1.0, 0.1, 0.01};

        for (double deltaTiempo : deltas) {
            System.out.println("Simulación con dt = " + deltaTiempo);
            System.out.printf("%-10s %-19s %-16s%n", "Tiempo", "Altura", "Velocidad");

            Proyectil proyectil = new Proyectil(60);
            double tiempo = 0.0;
            double alturaMaxima = Double.MIN_VALUE;

            while (proyectil.getAltura() >= 0) {
                System.out.printf("%,8.2f %,15.4f %,12.4f%n", tiempo, proyectil.getAltura(), proyectil.getVelocidad());

                proyectil.actualizar(deltaTiempo);
                tiempo = tiempo + deltaTiempo;

                alturaMaxima = Math.max(proyectil.getAltura(), alturaMaxima);
            }

            System.out.printf("Tiempo final: %,.2f\nAltura máxima: %,.4f\n\n\n\n", tiempo, alturaMaxima);
        }

        /*
         * TAREA DE INVESTIGACIÓN:
         *
         * * 1. ¿Dan el mismo resultado exacto al chocar contra el suelo?
         *
         * No, los resultados presentan variaciones significativas. Al usar diferentes
         * valores de Delta Time, el momento exacto en el que el proyectil detecta
         * que su altura es menor a cero cambia, lo que altera el tiempo de vuelo
         * y la altura máxima registrada en cada caso.
         *
         *
         * * 2. Justifica por qué la resolución del Delta Time modifica el resultado físico
         * final y cuál de los tres resultados es el más realista.
         *
         * La resolución influye porque la simulación divide un fenómeno continuo en
         * pasos discretos. Con un Delta Time grande, el programa ignora los cambios
         * sutiles de velocidad que ocurren entre cada "foto" del cálculo, acumulando
         * un margen de error mayor. El resultado de 0.01 es el más realista de los tres,
         * ya que al procesar más actualizaciones por segundo, la trayectoria se ajusta
         * con mucha más precisión a la curva física real.
         */
    }
}