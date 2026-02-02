package E320GlobosExplosivos;

import java.util.Random;

public class Globo {
    // Atributos del globo
    private int capacidad;       // Capacidad máxima de aire que puede contener
    private int aire;            // Cantidad de aire actual en el globo
    private boolean explotado;   // Indica si el globo ha explotado
    private Random random;       // Objeto para generar números aleatorios
    
    // Constructor sin parámetros: crea un globo con capacidad aleatoria (10-50)
    public Globo() {
        this.random = new Random();  // Inicializar el generador de números aleatorios
        // Generar capacidad aleatoria entre 10 y 50 (41 números posibles empezando en 10)
        this.capacidad = random.nextInt(41) + 10;
        this.aire = 0;          // Al inicio no tiene aire
        this.explotado = false; // Al inicio no está explotado
    }
    
    // Constructor con capacidad específica: crea un globo con capacidad dada
    public Globo(int capacidadMaxima) {
        this.random = new Random();  // Inicializar el generador de números aleatorios
        this.capacidad = capacidadMaxima;  // Usar la capacidad proporcionada
        this.aire = 0;          // Al inicio no tiene aire
        this.explotado = false; // Al inicio no está explotado
    }
    
    // Método para inflar el globo con cierta cantidad de aire
    public void inflar(int cantidad) {
        // Solo inflar si el globo no ha explotado y la cantidad es positiva
        if (!explotado && cantidad > 0) {
            aire += cantidad;  // Añadir la cantidad al aire actual
            
            // Verificar si se ha superado la capacidad (globo explota)
            if (aire > capacidad) {
                explotado = true;  // Marcar como explotado
            }
        }
    }
    
    // Método para obtener una representación visual del globo
    public String toString() {
        // StringBuilder es más eficiente que concatenar Strings directamente
        StringBuilder resultado = new StringBuilder();
        
        // Añadir un asterisco por cada unidad de aire en el globo
        for (int i = 0; i < aire; i++) {
            resultado.append("*");
        }
        
        // Añadir una "O" por cada unidad de aire que falta para llenar el globo
        for (int i = 0; i < (capacidad - aire); i++) {
            resultado.append("O");
        }
        
        return resultado.toString();  // Convertir StringBuilder a String
    }
    
    // Método que indica si el globo ha explotado
    public boolean estaExplotado() {
        return explotado;
    }
    
    // Método getter para obtener la cantidad de aire actual
    public int getAire() {
        return aire;
    }
    
    // Método getter para obtener la capacidad máxima del globo
    public int getCapacidad() {
        return capacidad;
    }
    
    // Método para calcular cuánto aire le falta al globo para explotar
    public int getAireRestante() {
        return capacidad - aire;
    }
    
    // Método para reiniciar el globo (poner aire a 0 y estado a no explotado)
    public void reset() {
        this.aire = 0;          // Vaciar el globo
        this.explotado = false; // Restablecer estado a no explotado
    }
}