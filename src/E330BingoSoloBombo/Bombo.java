package E330BingoSoloBombo;

import java.util.ArrayList;
import java.util.Random;


public class Bombo {
    private ArrayList<Integer> bombo;
    private ArrayList<Integer> bolasSacadas = new ArrayList<Integer>();
    private Random aleatorio = new Random();
    private int totalBolas;

    public Bombo (int cantidadBolas) {
        totalBolas = cantidadBolas;

        bombo = new ArrayList<>(cantidadBolas);

        for (int i = 1; i <= cantidadBolas; i++) {
            bombo.add(i);
        }

        revuelveBombo();
    }

    public int getTotalBolas() {
        return totalBolas;
    }

    public int dameBola() {
        if (!hayBolas()) {
            throw new IllegalStateException("No quedan bolas en el bombo");
        }

        int indiceASacar = aleatorio.nextInt(0, bombo.size());

        int bola = bombo.get(indiceASacar);

        bolasSacadas.add(bola);

        bombo.remove(indiceASacar);
        
        return bola;
    }

    public void revuelveBombo() {
        // Fisher-Yates shuffle: desde la última posición hasta la segundo
        for (int i = bombo.size() - 1; i >= 1; i--) {
            
            int j = aleatorio.nextInt(i + 1);
            
            int temporal = bombo.get(i);
            
            bombo.set(i, bombo.get(j));
            bombo.set(j, temporal);
        }
    }

    public boolean hayBolas() {
        return !bombo.isEmpty();
    }

    public boolean bolaEstaDentro(int bolaBuscada) {
        return bombo.contains(bolaBuscada);
    }

    public String toString() {
        StringBuilder comparacionBolas = new StringBuilder("\nBolas que no han salido: [");
        
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