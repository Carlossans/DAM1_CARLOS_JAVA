package E305RelojHMBasico;

public class Principal {
    public static void main(String[] args) {
        Reloj reloj1 = new Reloj();
        Reloj reloj2 = new Reloj(150);
        Reloj reloj3 = new Reloj(3, 45);

        System.out.println(reloj1);
        System.out.println(reloj2);
        System.out.println(reloj3);

        reloj1.tick();

        reloj1.sumarMinutos(80);

        System.out.println("Tras tick y sumar unos pocos minutos: " + reloj1);

        reloj1.restarMinutos(20000);

        System.out.println("Restado muchos minutos: " + reloj1);

        int diferenciaMinutos = reloj2.diferenciaMinutos(reloj3);

        System.out.println("Diferencia en minutos entre reloj2 y reloj3: " + diferenciaMinutos);

        Reloj difReloj = reloj2.diferenciaReloj(reloj3);

        System.out.println("Diferencia en Reloj entre reloj2 y reloj3: " + difReloj);
    }
}
