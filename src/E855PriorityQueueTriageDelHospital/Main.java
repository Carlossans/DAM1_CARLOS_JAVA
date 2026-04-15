package E855PriorityQueueTriageDelHospital;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author Santos
 * @version 1.0
 */
public class Main {
    public static void main (String[] args) {
        PriorityQueue<Paciente> colaTriage = new PriorityQueue<>();
        Random random = new Random();
        
       colaTriage.offer(new Paciente("Elena", "Brazo roto", 2));
       colaTriage.offer(new Paciente("Marcos", "Dolor de garganta", 3));
       colaTriage.offer(new Paciente("Sofia", "Ataque cardiaco", 1));
       colaTriage.offer(new Paciente("Luis", "Fiebre alta", 2));
       colaTriage.offer(new Paciente("Carmen", "Corte leve", 2));
       colaTriage.offer(new Paciente("Jorge", "Dificultad para respirar", 1));


        while (!colaTriage.isEmpty()) {
            Paciente atendido = colaTriage.poll();
            System.out.println("Atendiendo a: " + atendido);

            if (random.nextDouble() < 0.30) {
                int prioridadAleatoria = random.nextInt(3) + 1;
                Paciente nuevo = new Paciente("Paciente de Emergencia", "Susto", prioridadAleatoria);
                colaTriage.offer(nuevo);
                System.out.println("! Ha llegado un nuevo paciente: " + nuevo);
            }
        }
        System.out.println("No hay gente en la sala de espera");
    }
}
