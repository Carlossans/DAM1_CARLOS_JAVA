package E330BingoSoloBombo;

import java.util.Random;
import java.util.ArrayList;

public class Carton {
    private ArrayList<Integer> numeros;
    private ArrayList<Boolean> marcas;
    private Bombo bombo; // atributo del objeto cartón
    private Random aleatorio = new Random();

    public Carton (int cantidadNumeros, Bombo bombo) {
        this.bombo = bombo;
        numeros = new ArrayList<>();
        marcas = new ArrayList<>();

        rellenarAleatoriamente(cantidadNumeros);
    }

    public void rellenarAleatoriamente(int cantidadNumeros) {

        int totalBolas = bombo.getTotalBolas();

        while (numeros.size() < cantidadNumeros) {
            int numero = aleatorio.nextInt(totalBolas + 1);

            if (!numeros.contains(numero)) {
                numeros.add(numero);
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

        for (int i = 0; i < numeros.size(); i++) {
            if (!marcas.get(i)) {
                carton.append(numeros.get(i)).append(" ");
            } else {
                carton.append("[").append(numeros.get(i)).append("] ");
            }
        }

        return carton.toString();
    }
}
