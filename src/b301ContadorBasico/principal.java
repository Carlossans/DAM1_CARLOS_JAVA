package b301ContadorBasico;


public class principal {
    public static void main(String[] args) {

        contador c = new contador(30, "zapatillas");
        contador c2 = new contador(10, "llaves");
        contador c3 = new contador(30, "balones");
        

        if (c.equals(c2)) {
            System.out.println("El contador c es igual al contador c2");
        } else {
            System.out.println("El contador c es distinto al contador c2");
        }

        contador c4 = (contador) c2.clone();

        c4.incrementar(5);

        System.out.println("Contador c2: " + c2);
        System.out.println("Contador c4: " + c4);
        
    }
}