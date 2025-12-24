package nose;

import java.util.Scanner;

public class E912Checkmult750 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        do {
            int num = teclado.nextInt();
            if (num == 0) break;

            int totalCeros = 0;

            do {
                int res = 1;

                do {
                    int digito = num % 10;
                    num = num / 10;

                    if (digito == 0) {
                        totalCeros++;
                    } else {
                        res = res * digito;
                    }
                } while (num > 0);

                num = res;
            } while (num >= 10);

            System.out.println(num + "" + totalCeros);
        } while (true);
    }
}