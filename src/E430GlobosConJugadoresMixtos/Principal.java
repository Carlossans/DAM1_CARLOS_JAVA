package E430GlobosConJugadoresMixtos;

/**
 * CLASE PRINCIPAL (PUNTO DE ENTRADA)
 * ==================================
 * Esta es la clase que contiene el método main() - el punto de entrada
 * del programa. Su única responsabilidad es crear el juego e iniciarlo.
 *
 * PATRÓN USADO: "Programa Principal"
 * - Principal.java: Solo inicia el programa (controlador)
 * - Juego.java: Controla la lógica del juego
 * - Jugador/Globo: Modelos de datos
 *
 * ESTO ES "ORIENTACIÓN A OBJETOS" PORQUE:
 * 1. Separamos responsabilidades en clases diferentes
 * 2. Usamos herencia (JugadorHumano y JugadorCpu heredan de Jugador)
 * 3. Usamos polimorfismo (tratamos a humanos y CPU como Jugador)
 * 4. Encapsulamos datos (campos privados con getters)
 * 5. Cada clase tiene una responsabilidad clara
 */
public class Principal {

    /**
     * MÉTODO MAIN - Punto de entrada del programa
     * ===========================================
     * Este método es el primero que se ejecuta cuando corremos el programa.
     * Su trabajo es simple:
     * 1. Crear una instancia de Juego
     * 2. Configurar los jugadores (llama a configurarJugadores)
     * 3. Empezar el juego (llama a empezar)
     *
     * @param args Argumentos de línea de comandos (no usados)
     */
    public static void main(String[] args) {
        // Creamos el objeto Juego que controlará toda la partida
        Juego juego = new Juego();

        // Configuramos los jugadores (HH, HC, CH, CC o personalizado)
        // Esto muestra el menú y pide al usuario que elija
        juego.configurar();

        // Iniciamos el juego - esto ejecuta el bucle principal
        // y no termina hasta que alguien gane o se acaben las rondas
        juego.empezar();
    }
}
