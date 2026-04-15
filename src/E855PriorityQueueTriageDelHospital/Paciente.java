package E855PriorityQueueTriageDelHospital;

/**
 * @author Santos
 * @version 1.0
 */
public class Paciente implements Comparable<Paciente>{

    private String nombre, sintoma;
    private int nivelGravedad;

    /**
     * @param nombre
     * @param sintoma
     * @param nivelGravedad
     */
    public Paciente(String nombre, String sintoma, int nivelGravedad) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.nivelGravedad = nivelGravedad;
    }

    /**
     *
     * @param paciente
     * @return devuelve un int
     */
    public int getNivelGravedad(Paciente paciente) {
        return nivelGravedad;
    }

    /**
     *
     * @param paciente
     * @return devuelve un String
     */
    public String getNombre(Paciente paciente) {
        return nombre;
    }

    /**
     *
     * @param paciente
     * @return devuelve un Sitring
     */
    public String getSintoma(Paciente paciente) {
        return sintoma;
    }

    /**
     *
     * @param otro
     * @return devuelve un int
     */
    public int compareTo(Paciente otro) {
        return this.nivelGravedad - otro.nivelGravedad;
    }

    /**
     *
     * @return devuelve un String
     */
    public String toString() {
        return String.format("\n[Prioridad %d] %s - %s\n", nivelGravedad, nombre, sintoma);
    }
}
