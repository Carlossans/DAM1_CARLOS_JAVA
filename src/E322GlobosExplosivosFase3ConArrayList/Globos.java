package E322GlobosExplosivosFase3ConArrayList;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Globos {
    private int capacidad;  // Aire máximo que soporta el globo
    private int aireActual; // Aire que tiene en el momento

    // Constructor: se ejecuta al crear un "new Globos()"
    public Globos() {
        Random aleatorio = new Random(); // Creamos el generador de aleatorios
        this.capacidad = aleatorio.nextInt(41) + 10; // Calcula un número entre 10 y 50
        this.aireActual = 0; // Al nacer, el globo está vacío
    }

    public void inflar(int cantidad) {
        this.aireActual = this.aireActual + cantidad; // Suma la cantidad recibida al total
    }

    public boolean explotado() {
        return aireActual > capacidad; // Devuelve true si el aire supera la capacidad
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(); // Usamos StringBuilder por eficiencia al crear cadenas
        String resultado = "";
        
        // Bucle para poner un asterisco por cada unidad de aire (sin pasarse de la capacidad)
        for (int i = 0; i < aireActual && i < capacidad; i++) {
            sb.append("*");
        }
        // Bucle para rellenar con "O" el espacio que falta hasta la capacidad máxima
        for (int i = aireActual; i < capacidad; i++) {
            sb.append("O");
        }
        
        resultado = sb.toString(); // Convertimos el constructor de cadenas a String real

        // Si el globo ha explotado, añadimos el texto informativo
        if (explotado()) {
            resultado = resultado + " BOOM";
        }
        return resultado; // Devolvemos la representación visual del globo
    }
}

// Clase que controla el flujo del juego
class Partida {
    private ArrayList<Globos> historialGlobos; // Lista para guardar todos los globos usados
    private int victoriasJugador1; // Contador de rondas ganadas por J1
    private int victoriasJugador2; // Contador de rondas ganadas por J2
    private Scanner teclado;

    // Constructor de la partida
    public Partida() {
        this.historialGlobos = new ArrayList<>(); // Inicializa la lista vacía
        this.victoriasJugador1 = 0; // Empiezan con 0 puntos
        this.victoriasJugador2 = 0;
        this.teclado = new Scanner(System.in); // Inicializa el lector de teclado

        // Creamos los 5 globos desde el inicio (cada uno con capacidad aleatoria)
        for (int i = 0; i < 5; i++) {
            historialGlobos.add(new Globos());
        }
    }

    // Método principal que ejecuta la lógica de la Fase 3
    public void jugar() {
        System.out.println("INICIO DEL JUEGO DE LOS GLOBOS EXPLOSIVOS");

        // Bucle de máximo 5 rondas
        for (int ronda = 1; ronda <= 5; ronda++) {
            System.out.println("\nRONDA " + ronda);
            Globos globoActual = historialGlobos.get(ronda - 1); // Usamos el globo ya creado

            boolean turnoJugador1 = true; // Control de turnos (empieza J1)
            
            // Mientras el globo actual no explote, seguimos pidiendo aire
            while (!globoActual.explotado()) {
                // Si es el turno del J1 ponemos un 1, si no, un 2
                int jugador = turnoJugador1 ? 1 : 2; 
                System.out.print("Jugador " + jugador + ", ¿cuánto aire soplas?: ");
                int soplo = teclado.nextInt(); // Lee el número entero
                globoActual.inflar(soplo); // Infla el globo

                System.out.println("Estado: " + globoActual.toString()); // Muestra los asteriscos/oes

                // Si al inflar ha explotado, comprobamos quién ha perdido
                if (globoActual.explotado()) {
                    if (turnoJugador1) {
                        System.out.println("Explotó. Gana el Jugador 2");
                        victoriasJugador2++; // El J1 lo explotó, punto para el J2
                    } else {
                        System.out.println("Explotó. Gana el Jugador 1");
                        victoriasJugador1++; // El J2 lo explotó, punto para el J1
                    }
                }
                turnoJugador1 = !turnoJugador1; // Cambiamos el valor (de true a false o viceversa)
            }

            // Muestra cómo van los puntos tras terminar la ronda
            System.out.println("PUNTUACIÓN J1 [" + victoriasJugador1 + "] - J2 [" + victoriasJugador2 + "]");

            // Si alguien llega a 3 victorias, el juego termina antes de las 5 rondas
            if (victoriasJugador1 == 3 || victoriasJugador2 == 3) {
                break; // Rompe el bucle de rondas
            }
        }
        mostrarResultadoFinal(); // Llama al método para el resumen final
    }

    // Método para imprimir el resumen de la partida
    private void mostrarResultadoFinal() {
        System.out.println("\n--- RESULTADO FINAL ---");
        if (victoriasJugador1 > victoriasJugador2) {
            System.out.println("EL GANADOR ES EL JUGADOR 1");
        } else {
            System.out.println("EL GANADOR ES EL JUGADOR 2");
        }

        System.out.println("\nRESUMEN DE LOS 5 GLOBOS:");
        // Recorre el ArrayList para mostrar cómo quedó cada globo (jugado o no)
        for (int i = 0; i < historialGlobos.size(); i++) {
            System.out.println("Globo " + (i + 1) + ": " + historialGlobos.get(i).toString());
        }
    }
}

