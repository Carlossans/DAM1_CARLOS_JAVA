package E330BingoSoloBombo;

import java.util.Random;
import java.util.ArrayList;

public class Carton {
    private ArrayList<Integer> numeros;
    private ArrayList<Boolean> marcas;
    private Bombo bombo;
    private Random aleatorio = new Random();
    private int id;
    private static int contadorId = 1;

    public Carton (Bombo bombo) {
        int cantidadNumerosCalculada = Math.max(1, bombo.getTotalBolas() / 6);

        this.bombo = bombo;
        this.id = contadorId++;
        numeros = new ArrayList<>();
        marcas = new ArrayList<>();

        rellenarAleatoriamente(cantidadNumerosCalculada);
    }

    public void rellenarAleatoriamente(int cantidadNumeros) {
        int totalBolas = bombo.getTotalBolas();

        while (numeros.size() < cantidadNumeros) {
            int num = aleatorio.nextInt(totalBolas) + 1;

            if (!numeros.contains(num)) {
                numeros.add(num);
                marcas.add(false);
            }
        }
    }

    public void anotaBola (int bola) {
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) == bola) {
                marcas.set(i, true);
            }
        }
    }

    public boolean hayBingo() {
        for (Boolean marcada : marcas) {
            if(!marcada) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder carton = new StringBuilder();
        carton.append("CARTÓN ").append(id).append(": ");

        for (int i = 0; i < numeros.size(); i++) {
            if (marcas.get(i)) {
                carton.append("[").append(numeros.get(i)).append("] ");
            } else {
                carton.append(numeros.get(i)).append(" ");
            }
        }

        return carton.toString();
    }
}
