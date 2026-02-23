package E330BingoSoloBombo;

import java.util.ArrayList;
import java.util.Random;


public class Bombo {
    private ArrayList<Integer> bombo;
    private ArrayList<Integer> bolasSacadas;
    private Random aleatorio;
    private int totalBolas;

    public Bombo (int cantidadBolas) {
        totalBolas = cantidadBolas;
        aleatorio = new Random();
        bombo = new ArrayList<>(cantidadBolas);
        bolasSacadas = new ArrayList<>();

        for (int i = 1; i <= cantidadBolas; i++) {
            bombo.add(i);
        }

        revuelveBombo();
    }

    public int getTotalBolas() {
        return totalBolas;
    }

    public int dameBola() {

        int indiceASacar = bombo.size() - 1;

        int bola = bombo.get(indiceASacar);

        bolasSacadas.add(bola);

        bombo.remove(indiceASacar);
        
        return bola;
    }

    public void revuelveBombo() {
        // Fisher-Yates shuffle: desde la última posición hasta la segunda
        for (int posicionActual = bombo.size() - 1; posicionActual >= 1; posicionActual--) {
            
            int posicionAleatoria = aleatorio.nextInt(posicionActual + 1);

            int temporal = bombo.get(posicionActual);
            
            bombo.set(posicionActual, bombo.get(posicionAleatoria));
            bombo.set(posicionAleatoria, temporal);
        }
    }

    public boolean hayBolas() {
        return !bombo.isEmpty();
    }

    public String toString() {
        StringBuilder comparacionBolas = new StringBuilder("Bolas que no han salido: [");
        
        for (Integer bola : bombo) {
            comparacionBolas.append(bola).append(" ");
        }
        comparacionBolas.append("] \n\nBolas que ya han salido: [");
        for (Integer bola : bolasSacadas) {
            comparacionBolas.append(bola).append(" ");
        }
        comparacionBolas.append("]");
        
        return comparacionBolas.toString();
    }
}