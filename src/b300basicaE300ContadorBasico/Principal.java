package b300basicaE300ContadorBasico;

public class Principal {
    public static void main(String[] args) {
        Contador c = new Contador(23);
        c.setValor(-35000);
        c.setValor(99999);
        c.incrementar();
        c.incrementar();
        c.decrementar();
        IO.println(c.getValor());
    }
}
