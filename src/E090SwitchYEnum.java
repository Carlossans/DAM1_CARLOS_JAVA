import java.util.Scanner;

public class E090SwitchYEnum {

    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);

        System.out.println("Introduce un número del 1 al 7 para mostrar el día de la semana correspondiente:");
        int dia = teclado.nextInt();

        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sábado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("Número no válido. Introduce un número del 1 al 7.");
        }

        System.out.println("Introduce un mes:");
        String mesInput = teclado.next();
        Mes mesEnum;

        mesEnum = Mes.valueOf(mesInput.toUpperCase());

        switch (mesEnum) {
            case ENERO, FEBRERO, DICIEMBRE:
                System.out.println("Invierno");
                break;
            case MARZO, ABRIL, MAYO:
                System.out.println("Primavera");
                break;
            case JUNIO, JULIO, AGOSTO:
                System.out.println("Verano");
                break;
            case SEPTIEMBRE, OCTUBRE, NOVIEMBRE:
                System.out.println("Otoño");
                break;
        }

        System.out.println("Introduce una nota del 1 al 10:");
        int nota = teclado.nextInt();

        switch (nota) {
            case 9, 10:
                System.out.println("Sobresaliente");
                break;
            case 7, 8:
                System.out.println("Notable");
                break;
            case 5, 6:
                System.out.println("Aprobado");
                break;
            case 0, 1, 2, 3, 4:
                System.out.println("Suspenso");
                break;
            default:
                System.out.println("Nota no válida. Introduce una nota del 1 al 10.");
        }

        System.out.println("Introduce una dirección (NORTE, SUR, ESTE, OESTE):");
        String direccion = teclado.nextLine().toUpperCase();
        Direccion direccionEnum = Direccion.valueOf(direccion);

        switch (direccionEnum) {
            case NORTE:
                System.out.println("Avanzar hacia el norte");
                break;
            case SUR:
                System.out.println("Retroceder hacia el sur");
                break;
            case ESTE:
                System.out.println("Desplazarse hacia el este");
                break;
            case OESTE:
                System.out.println("Desplazarse hacia el oeste");
                break;
        }
    }

    public enum Mes  {
        ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE
    }

    public enum Direccion {
        NORTE, SUR, ESTE, OESTE
    }
}
