package nose;
import java.util.Scanner;
public class E902HigosRobados788 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int casosPrueba = teclado.nextInt();
        teclado.nextLine();

        for (int i = 0; i < casosPrueba; i++) {
           int personas = teclado.nextInt();
           int higosRobados = teclado.nextInt();
           int higosManola = (higosRobados / personas) + (higosRobados % personas);
            System.out.println(higosManola);
        }
    }
}