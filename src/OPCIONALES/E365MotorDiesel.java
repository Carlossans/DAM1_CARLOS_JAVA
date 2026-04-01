
//Para la simulación final, en tu programa principal, simula 15 segundos con un deltaTiempo de 0.1 segundos. Enciende el coche, pisa el acelerador al 80% y muestra iteración a iteración la evolución de Velocidad y RPM. A los 10 segundos, suelta el acelerador a 0.0 y observa cómo el freno motor y la resistencia detienen gradualmente el vehículo.

package OPCIONALES;

import java.lang.classfile.attribute.SourceFileAttribute;

interface EstrategiaCurvarPar {
    double calcularPar(double rpm);
}

class EstrategiaTramosFijos implements EstrategiaCurvarPar{
    public double calcularPar(double rpm) {
        if (rpm >= 800 && rpm < 1500) return 150;
        else if (rpm >= 1500 && rpm <= 2500) return 250;
        return 0;
    }
}

class EstrategiaInterpolacionLineal implements EstrategiaCurvarPar {
    public double calcularPar(double rpm) {
        if (rpm < 800 || rpm > 4500) return 0;
        if (rpm <= 2000) {
            return 100 + (rpm - 800) * (350 - 100) / (2000 - 800);
        } else {
            return 350 + (rpm - 2000) * (50 - 350) / (4500 - 2000);
        }
    }
}

class EstrategiaParabolica implements EstrategiaCurvarPar {
    public double calcularPar(double rpm) {
        if (rpm < 800 || rpm > 4500) return 0;
        double a = -0.00008;
        double h = 2500;
        double k = 350;
        double par = a * Math.pow(rpm - h, 2 ) + k;
        return Math.max(0, par);
    }
}

class MotorDiesel {
    private double rpmActuales = 0;
    private double acelerador = 0;
    private boolean encendido = false;
    private final double inerciaMotor = 0.2;
    private final double friccionBase = 20;
    private EstrategiaCurvarPar estrategia;

    public MotorDiesel(EstrategiaCurvarPar estrategia) {
        this.estrategia = estrategia;
    }

    public void encender() {
        this.encendido = true;
        this.rpmActuales = 800;
    }

    public void apagar() {
        this.encendido = false;
        this.rpmActuales = 0;
    }

    public void setAcelerador(double valor) {
        this.acelerador = Math.min(1.0, Math.max(0, valor)); // ni idea de lo que es Math.clam ;)
    }

    public double getRpmActuales() {
        return rpmActuales;
    }

    public void setRpmActuales(double rpm) {
        this.rpmActuales = rpm;
    }

    public double actulizar (double deltaTiempo) {
        if (!encendido) return 0;

        double parDisponible = estrategia.calcularPar(rpmActuales);

        double parGenerado = parDisponible * acelerador;

        double fricciontotal = friccionBase;

        double parNeto = parGenerado - fricciontotal;

        double aceleracionAngular = parNeto / inerciaMotor;

        rpmActuales = rpmActuales + aceleracionAngular * deltaTiempo;

        if (rpmActuales < 800) rpmActuales = 800;
        if (rpmActuales > 4500) rpmActuales = 4500;

        return parGenerado;
    }
}

class Coche {
    private MotorDiesel motor;
    private double velocidadActual = 0;
    private final double masa = 1400;

    public Coche(MotorDiesel motor) {
        this.motor = motor;
    }

    public void actualizar(double deltaTiempo) {
        double parMotor = motor.actulizar(deltaTiempo);

        double aceleracionLineal = parMotor / masa;

        velocidadActual = velocidadActual + aceleracionLineal * deltaTiempo;

        if (velocidadActual > 0) velocidadActual = velocidadActual - 0.1 * deltaTiempo;

        double nuevasRpm = 800 + (velocidadActual * 60);
        motor.setRpmActuales(Math.min(4500, nuevasRpm));
    }

    public double getVelocidadKmh() {
        return velocidadActual * 3.6;
    }

    public double getRpm() {
        return motor.getRpmActuales();
    }
}

public class E365MotorDiesel {
    public static void main(String[] args) {
        System.out.println("Estrategías de par");
        EstrategiaCurvarPar[] estrategias = { new EstrategiaTramosFijos(), new EstrategiaInterpolacionLineal(), new EstrategiaParabolica()};

        for (EstrategiaCurvarPar estrategia : estrategias) {
            System.out.println("\nEstretegia: " + estrategia.getClass().getSimpleName());
            for (int rpm = 800; rpm <= 4500 ; rpm = rpm + 100) {
                double par = estrategia.calcularPar(rpm);
                int numAsteriscos = (int) (par / 10);
                System.out.printf("%4d RPM | %s %.1f Nm", rpm, "*".repeat(Math.max(0, numAsteriscos)), par);
            }
        }

        System.out.println("Simulación de 15 segundos");
        MotorDiesel miMotor = new MotorDiesel(new EstrategiaParabolica());
        Coche miCoche = new Coche(miMotor);

        miMotor.encender();
        double deltaTiempo = 0.1;
        double tiempoTotal = 0;

        System.out.printf("%-10s | %-10s | %-10s | %-10s\n", "Tiempo (s)", "Acelrador", "Velocidad (Km/h)", "RPM");

        while (tiempoTotal <= 15) {
            if (tiempoTotal < 10) miMotor.setAcelerador(0.8);
            else miMotor.setAcelerador(0);
        }

        miCoche.actualizar(deltaTiempo);

        if (Math.round(tiempoTotal * 10) % 10 == 0) System.out.printf("%-10.1f | %-10.1f  | %-10.1f | %-10.0f\n", tiempoTotal, (tiempoTotal < 10 ? 0.8 : 0), miCoche.getVelocidadKmh(), miCoche.getRpm());

        tiempoTotal = tiempoTotal + deltaTiempo;
    }
}








