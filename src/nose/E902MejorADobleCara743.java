package nose;

import java.util.Scanner;

public class E902MejorADobleCara743 {

    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);

        do {
            n = sc.nextInt();

            int ahorro = 0;

            for (int i = 0; i < n; i++) {
                int paginas = sc.nextInt();
                int hojasCaraSimple = paginas;
                int hojasDobleCara = (paginas + 1) / 2;
                ahorro += (hojasCaraSimple - hojasDobleCara);
            }

            System.out.println(ahorro);
        } while ( n != 0);
    }
}

