package E322GlobosExplosivosFase3ConArrayList;

public class Principal {
    // Método main: es el punto de entrada que busca la Máquina Virtual de Java
    public static void main(String[] args) {
        // Creamos el objeto "juego" de la clase Partida
        Partida juego = new Partida();

        // Llamamos al método que contiene toda la lógica
        juego.jugar();
    }
}