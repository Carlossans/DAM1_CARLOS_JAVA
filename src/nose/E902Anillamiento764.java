package nose;
import java.util.Scanner;
public class E902Anillamiento764 {
    public static void main(String[] args) {
        int campannas = 0, capturadas = 0, anilladas = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            int res = 0;
            campannas = teclado.nextInt();
            if (campannas == 0) break;

            for (int i = 0; i < campannas; i++) {
                capturadas = teclado.nextInt();
                anilladas = teclado.nextInt();

                res = res + (capturadas - anilladas);
            }
            System.out.println(res);
        } while (true) ;
    }
}