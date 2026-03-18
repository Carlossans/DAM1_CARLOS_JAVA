package E430GlobosConJugadoresMixtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Jugador {
    protected String nombre;
    protected int rondasGanadas;
    protected int rondasPerdidas;
    protected int aireTotalSoplado;
    protected int soploAnterior;
    protected static final int MIN_SOPLO = 1;
    protected static final int MAX_SOPLO = 10;
    protected static final int MAX_SOPLO_DOS_RONDAS = 11;
    protected static Scanner scanner = new Scanner(System.in);

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.rondasGanadas = 0;
        this.rondasPerdidas = 0;
        this.aireTotalSoplado = 0;
        this.soploAnterior = 0;
    }

    public abstract int determinarSoplo();

    public int determinarSoploConCansancio() {
        int maxSoplo = calcularSoplidoMaximo();
        int soplo;

        do {
            soplo = determinarSoplo();
            if (soplo > maxSoplo) {
                System.out.println("¡Estás cansado! No puedes soplar más de " + maxSoplo + " unidades en este turno.");
            }
        } while (soplo > maxSoplo);

        registrarSoplo(soplo);
        return soplo;
    }

    protected int calcularSoplidoMaximo() {
        if (soploAnterior == 0) {
            return MAX_SOPLO;
        }
        return MAX_SOPLO_DOS_RONDAS - soploAnterior;
    }

    protected void registrarSoplo(int cantidad) {
        this.soploAnterior = cantidad;
        this.aireTotalSoplado += cantidad;
    }

    public void reiniciarCansancioRonda() {
        this.soploAnterior = 0;
    }

    public void ganarRonda() {
        rondasGanadas++;
    }

    public void perderRonda() {
        rondasPerdidas++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    public int getRondasPerdidas() {
        return rondasPerdidas;
    }

    public int getAireTotalSoplado() {
        return aireTotalSoplado;
    }

    public int getSoploAnterior() {
        return soploAnterior;
    }

    public static List<Jugador> configurarJugadores() {
        List<Jugador> jugadores = new ArrayList<>();

        System.out.println("\n=== CONFIGURACIÓN DE JUGADORES ===");
        System.out.println("Selecciona el modo de juego:");
        System.out.println("1. Humano vs Humano (HH)");
        System.out.println("2. Humano vs CPU (HC)");
        System.out.println("3. CPU vs Humano (CH)");
        System.out.println("4. CPU vs CPU (CC)");
        System.out.println("5. Personalizado (N jugadores)");

        int opcion = leerOpcion(1, 5);

        switch (opcion) {
            case 1 -> {
                String nombre1 = leerString("Nombre del Jugador 1: ");
                String nombre2 = leerString("Nombre del Jugador 2: ");
                jugadores.add(new JugadorHumano(nombre1.isEmpty() ? "Jugador 1" : nombre1));
                jugadores.add(new JugadorHumano(nombre2.isEmpty() ? "Jugador 2" : nombre2));
            }
            case 2 -> {
                String nombre1 = leerString("Nombre del Jugador Humano: ");
                jugadores.add(new JugadorHumano(nombre1.isEmpty() ? "Humano" : nombre1));
                jugadores.add(new JugadorCpu("CPU"));
            }
            case 3 -> {
                String nombre2 = leerString("Nombre del Jugador Humano: ");
                jugadores.add(new JugadorCpu("CPU"));
                jugadores.add(new JugadorHumano(nombre2.isEmpty() ? "Humano" : nombre2));
            }
            case 4 -> {
                jugadores.add(new JugadorCpu("CPU-1"));
                jugadores.add(new JugadorCpu("CPU-2"));
            }
            case 5 -> configurarJugadoresPersonalizado(jugadores);
        }

        return jugadores;
    }

    private static void configurarJugadoresPersonalizado(List<Jugador> jugadores) {
        int numHumanos = leerOpcion("¿Cuántos jugadores humanos? ", 0, 10);
        int numCpus = leerOpcion("¿Cuántos jugadores CPU? ", 0, 10);

        for (int i = 1; i <= numHumanos; i++) {
            String nombre = leerString("Nombre del Humano " + i + ": ");
            jugadores.add(new JugadorHumano(nombre.isEmpty() ? "Humano " + i : nombre));
        }

        for (int i = 1; i <= numCpus; i++) {
            jugadores.add(new JugadorCpu("CPU-" + i));
        }

        if (jugadores.isEmpty()) {
            System.out.println("Debe haber al menos un jugador. Añadiendo 2 CPUs por defecto.");
            jugadores.add(new JugadorCpu("CPU-1"));
            jugadores.add(new JugadorCpu("CPU-2"));
        }
    }

    private static int leerOpcion(int min, int max) {
        return leerOpcion("", min, max);
    }

    private static int leerOpcion(String prompt, int min, int max) {
        int numero = min;
        do {
            try {
                if (!prompt.isEmpty()) {
                    System.out.print(prompt);
                    numero = Integer.parseInt(scanner.nextLine());
                } else {
                    System.out.print("Elige una opción: ");
                    numero = Integer.parseInt(scanner.nextLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
            }
        } while (numero < min || numero > max);
        return numero;
    }

    private static String leerString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
