package E855PriorityQueueTriageDelHospital;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        ArrayList<Paciente> Pacientes = new ArrayList<>();
        ArrayList<Paciente> Primeros = new ArrayList<>();
        ArrayList<Paciente> Segundos = new ArrayList<>();
        ArrayList<Paciente> Terceros = new ArrayList<>();


       Pacientes.add(new Paciente("Elena", "Brazo roto", 2));
       Pacientes.add(new Paciente("Marcos", "Dolor de garganta", 3));
       Pacientes.add(new Paciente("Sofia", "Ataque cardiaco", 1));
       Pacientes.add(new Paciente("Luis", "Fiebre alta", 2));
       Pacientes.add(new Paciente("Carmen", "Corte leve", 2));
       Pacientes.add(new Paciente("Jorge", "Dificultad para respirar", 1));

        for (Paciente pacient : Pacientes) {
            if (pacient.getNivelGravedad(pacient) == 1) Primeros.add(pacient);
            else if (pacient.getNivelGravedad(pacient) ==2) Segundos.add(pacient);
            else Terceros.add(pacient);
        }

        System.out.println("Los primeros en ser atendidos son: \n");

        for (Paciente primer : Primeros) {
            System.out.println(primer.getNombre(primer) + "\n");
        }

        System.out.println("Los segundos en ser atendidos son: \n");

        for (Paciente segun : Segundos) {
            System.out.println(segun.getNombre(segun) + "\n");
        }

        System.out.println("Los terceros en ser atendidos son: \n");

        for (Paciente tercer : Terceros) {
            System.out.println(tercer.getNombre(tercer) + "\n");
        }
    }
}
