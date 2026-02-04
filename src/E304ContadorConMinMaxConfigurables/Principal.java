package E304ContadorConMinMaxConfigurables;

public class Principal {
    public static void main(String[] args) {
        System.out.println("CREACIÓN DE CONTADORES CON LÍMITES");

        Contador c1 = new Contador();
        System.out.println("c1 (constructor por defecto): " + c1);
        
        // Contador con valor y etiqueta (min=1, max=100 por defecto)
        Contador c2 = new Contador(30, "llaves");
        System.out.println("c2 (valor=30, etiqueta='llaves'): " + c2);
        
        // Contador con valor, etiqueta y límites personalizados
        Contador c3 = new Contador(5, "balones", 0, 10);
        System.out.println("c3 (valor=5, etiqueta='balones', min=0, max=10): " + c3);
        
        // Contador con etiqueta y límites (valor por defecto=50)
        Contador c4 = new Contador("grados", -10, 10);
        System.out.println("c4 (etiqueta='grados', min=-10, max=10): " + c4);
        
        System.out.println("\nUSO DE MÉTODOS");
        System.out.println("==============\n");

        // Probamos con c3 que tiene límites 0-10
        System.out.println("Probando con c3 (limites 0-10):");
        System.out.println("Valor inicial de c3: " + c3.getValor());
        
        c3.incrementar(3);
        System.out.println("c3 tras incrementar(3): " + c3);
        
        c3.incrementar(5); // Intentamos pasar del máximo (8 + 5 = 13, pero máximo es 10)
        System.out.println("c3 tras incrementar(5) [debería quedar en 10]: " + c3);
        
        c3.decrementar(15); // Intentamos pasar del mínimo (10 - 15 = -5, pero mínimo es 0)
        System.out.println("c3 tras decrementar(15) [debería quedar en 0]: " + c3);
        
        System.out.println("\nProbando cambio de límites en tiempo de ejecución:");
        System.out.println("Valor actual de c2: " + c2);
        System.out.println("Límites actuales de c2: min=" + c2.getMinimo() + ", max=" + c2.getMaximo());
        
        // Cambiamos los límites de c2
        c2.setMinimo(20);
        c2.setMaximo(80);
        System.out.println("Nuevos límites de c2: min=" + c2.getMinimo() + ", max=" + c2.getMaximo());
        System.out.println("c2 después de cambiar límites: " + c2);
        
        // Probamos que si ponemos un límite inválido no cambia
        System.out.println("\nIntentando poner mínimo mayor que máximo (no debería cambiar):");
        int maximoActual = c2.getMaximo();
        c2.setMinimo(90); // 90 > 80 (máximo actual) - no debería cambiar
        System.out.println("Después de setMinimo(90): min=" + c2.getMinimo() + ", max=" + c2.getMaximo());
        
        System.out.println("\nPRUEBAS DE EQUALS Y CLONE");
        System.out.println("=========================\n");
        
        Contador c5 = new Contador(25, "objetos", 0, 50);
        Contador c6 = c5.clone();
        
        System.out.println("c5: " + c5);
        System.out.println("c6 (clon de c5): " + c6);
        System.out.println("c5.equals(c6): " + c5.equals(c6));
        
        // Modificamos el clon
        c6.incrementar(10);
        c6.setEtiqueta("copias");
        System.out.println("\nDespués de modificar c6:");
        System.out.println("c5: " + c5);
        System.out.println("c6: " + c6);
        System.out.println("c5.equals(c6): " + c5.equals(c6));
        
        System.out.println("\nProbando reset:");
        c4.resetear();
        System.out.println("c4 tras resetear (debería ser 50, pero limitado por -10 a 10): " + c4);
    }
}