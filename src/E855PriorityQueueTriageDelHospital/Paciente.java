package E855PriorityQueueTriageDelHospital;

public class Paciente implements Comparable{

    private String nombre, sintoma;
    private int nivelGravedad;

    public Paciente(String nombre, String sintoma, int nivelGravedad) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.nivelGravedad = nivelGravedad;
    }

    public int getNivelGravedad(Paciente paciente) {
        return nivelGravedad;
    }

    public String getNombre(Paciente paciente) {
        return nombre;
    }

    public int compareTo(Object o) {
        return 0;
    }
}
