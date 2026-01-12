package b300basicaE300ContadorBasico;

public class Principal {
    public static void main(String[] args) {
        // Crear contador con valor por defecto
        Contador contador1 = new Contador();
        System.out.println("Contador por defecto: " + contador1);

        // Crear contador con valor específico
        Contador contador2 = new Contador(23);
        System.out.println("Contador con valor 23: " + contador2);

        // Crear contador con valor y etiqueta
        Contador contador3 = new Contador(50, " balones");
        System.out.println("Contador con etiqueta: " + contador3);

        Contador c = new Contador(23);
        c.setValor(-35000);
        c.setValor(99999);
        c.incrementar();
        c.incrementar();
        c.decrementar();

        System.out.println(c);

        // Probando métodos sobrecargados
        Contador c2 = new Contador(10);
        System.out.println("Antes: " + c2);
        c2.incrementar(5);
        System.out.println("Después de incrementar(5): " + c2);
        c2.decrementar(3);
        System.out.println("Después de decrementar(3): " + c2);
        c2.incrementar();
        System.out.println("Después de incrementar(): " + c2);

        c2.resetear();
        System.out.println("Después de resetear: " + c2);

        Contador c3 = new Contador(7, " balones");
        System.out.println(c3);
        c3.incrementar(3);
        System.out.println("Después de incrementar(3): " + c3);
    }
}
