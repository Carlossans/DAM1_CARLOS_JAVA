package E305RelojHMBasico;

public abstract class RelojTextual extends Reloj{

    public abstract String toString();
}

class RelojEspaniol extends RelojTextual{

    public String toString() {
        return switch (getH()) {
            case 12 -> "las doce";
            case 1, 13 -> "La una ";
            case 2, 14 -> "Las dos";
            case 3, 15 -> "Las tres";
            case 4, 16 -> "Las cuatro";
            case 5, 17 -> "Las cinco";
            case 6, 18 -> "Las seis";
            case 7, 19 -> "Las siete";
            case 8, 20 -> "Las ocho";
            case 9, 21 -> "Las nueve";
            case 10, 22 -> "Las diez";
            case 11, 23 -> "Las once";
            default -> "las doce";
        };
    }
}
