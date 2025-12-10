package nose;

import java.util.Scanner;

public class E902MejorADobleCara743 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            int n = sc.nextInt();

            if (n == 0) break;

            int ahorro = 0;

            for (int i = 0; i < n; i++) {
                int paginas = sc.nextInt();
                int hojasDobleCara = (paginas + 1) / 2;
                ahorro += (paginas - hojasDobleCara);
            }

            System.out.println(ahorro);
        } while (true);
    }
}

