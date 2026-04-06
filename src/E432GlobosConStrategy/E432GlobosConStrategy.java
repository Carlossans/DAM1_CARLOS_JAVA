package E432GlobosConStrategy;

import java.util.Random;
import java.util.Scanner;

public class E432GlobosConStrategy {

}

interface EstrategiaSoplo {
    int determinarSoplo(int minimo, int maximo);
}

class SoploAleatorio implements EstrategiaSoplo {
    private Random random = new Random();

    public int determinarSoplo(int minimo, int maximo) {
        return random.nextInt(minimo, maximo + 1);
    }
}

class SoploHumano implements EstrategiaSoplo {
    private Scanner teclado = new Scanner(System.in);

    public int determinarSoplo(int minimo, int maximo) {
        int soplo;
        do {
            System.out.printf("Introduce valor de soplido (entre %d y %d): ", minimo, maximo);
            soplo = teclado.nextInt();
        } while (soplo < minimo || soplo > maximo);
        return soplo;
    }
}

class SoploPrudente implements EstrategiaSoplo {
    public int determinarSoplo(int minimo, int maximo) {
        return minimo;
    }
}

class SoploTemerario implements EstrategiaSoplo {
    public int determinarSoplo(int minimo, int maximo) {
        return maximo;
    }
}
