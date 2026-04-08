package refactorizacion;

import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public final class Pruebasmenu {

    /**
     *
     * @author Carlos
     */
    /*default*/ private static final Logger LOGGER = Logger.getLogger(Pruebasmenu.class.getName());

    /**
     *
     * @author Carlos
     */
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in, StandardCharsets.UTF_8)) {
            int opcion;
            do {
                menu();
                opcion = leerOpcionValida(teclado);
                procesarOpcion(opcion);
            } while (opcion != 4);
        }
    }

    /**
     * Lee una opción válida del usuario (entre 1 y 4)
     */
    private static int leerOpcionValida(final Scanner teclado) {
        int opcion;
         
        while (true) {
            try {
                LOGGER.fine("TECLEA OPCIÓN(1 a 4):");
                opcion = teclado.nextInt();
                if (opcion > 0 && opcion < 5) {
                    return opcion;
                }
            } catch (java.util.InputMismatchException e) {
                teclado.nextLine();
            }
        }
    }

    /**
     * Procesa la opción seleccionada por el usuario
     */
    private static void procesarOpcion(final int opcion) {
        switch (opcion) {
            case 1:
                operacionesSimples();
                break;
            case 2:
                lecturaNotas();
                break;
            case 3:
                compararVariables();
                break;
            case 4:
                mostrarMensajeSalida();
                break;
            default:
                LOGGER.fine("Opcion no válida, prueba otra vez");
                break;
        }
    }

    /**
     * Muestra el mensaje de salida
     */
    private static void mostrarMensajeSalida() {
        LOGGER.fine("----------------------");
        LOGGER.fine("\tFIN");
        LOGGER.fine("----------------------");
    }

    /**
     *
     * @author Carlos
     */
    private static void menu() {
        LOGGER.fine("------------------------------------------------------------");
        LOGGER.fine("Ejercios de repaso\n");
        LOGGER.fine("\t1. EJERCICIO 1: operaciones simples");
        LOGGER.fine("\t2. EJERCICIO 2: lectura notas");
        LOGGER.fine("\t3. EJERCICIO 3: comparar valores");
        LOGGER.fine("\t4. Salir");
        LOGGER.fine("------------------------------------------------------------");
    }

    private Pruebasmenu() {}

    /**
     *
     * @author Carlos
     */
    public static void operacionesSimples() {
        // Operaciones con numero1 y numero2
        final int numero1 = 10;
        final int numero2 = 5;
        final int suma = numero1 + numero2;
        final int resta = numero1 - numero2;
        final int multiplicacion = numero1 * numero2;
        final int division = numero1 / numero2;
        final String superNecesario = " es igual a ";

        if (LOGGER.isLoggable(Level.FINE)) {
            LOGGER.fine("La suma de " + numero1 + " más " + numero2 + superNecesario + suma);
            LOGGER.fine("La resta de " + numero1 + " menos " + numero2 + superNecesario + resta);
            LOGGER.fine("La multipación de " + numero1 + " por " + numero2 + superNecesario + multiplicacion);
            LOGGER.fine("La division de " + numero1 + " entre " + numero2 + superNecesario + division + "\n");
        }
    }

    /**
     *
     * @author Carlos
     */
    public static void lecturaNotas() {
        try (Scanner teclado = new Scanner(System.in, StandardCharsets.UTF_8)) {
            final String nombreAlumno;
            final double evaluacion1;
            final double evaluacion2;
            final double evaluacion3;
            final double evaluacionFinal;

            LOGGER.fine("Nombre alumno: ");
            nombreAlumno = teclado.nextLine();

            evaluacion1 = leerDoubleConValidacion(teclado, "Nota primera evaluación: ");
            evaluacion2 = leerDoubleConValidacion(teclado, "Nota segunda evaluación: ");
            evaluacion3 = leerDoubleConValidacion(teclado, "Nota tercera evaluación: ");

            evaluacionFinal = (evaluacion1 + evaluacion2 + evaluacion3) / 3;

            if (LOGGER.isLoggable(Level.FINE)) {
                LOGGER.fine("La nota media de " + nombreAlumno + " es " + evaluacionFinal);
            }
        }
    }

    /**
     * Lee un valor double con validación de entrada
     */
    private static double leerDoubleConValidacion(final Scanner teclado, final String mensaje) {
         
        while(true) {
            try {
                LOGGER.fine(mensaje);
                return teclado.nextDouble();
            } catch (java.util.InputMismatchException e) {
                LOGGER.fine("Incorrecta, teclea de nuevo:");
                teclado.nextLine();
            }
        }
    }

    /**
     *
     * @author Carlos
     */
    public static void compararVariables() {
        try (Scanner teclado = new Scanner(System.in, StandardCharsets.UTF_8)) {
            final int variable1;
            final int variable2;

            LOGGER.fine("Teclea dos variables enteras: ");

            variable1 = leerIntConValidacion(teclado, "Variable variable1: ");
            variable2 = leerIntConValidacion(teclado, "Variable variable2: ");

            // comparamos
            if (variable1 == variable2) {
                LOGGER.fine("Las variables variable1 y variable2 son iguales.");
            } else if (variable1 < variable2) {
                LOGGER.fine("La variable variable1 es menor que variable2.");
            } else {
                LOGGER.fine("La variable variable1 es mayor que variable2.");
            }
        }
    }

    /**
     * Lee un valor entero con validación de entrada
     */
    private static int leerIntConValidacion(final Scanner teclado, final String mensaje) {
         
        while (true) {
            try {
                LOGGER.fine(mensaje);
                return teclado.nextInt();
            } catch (java.util.InputMismatchException e) {
                LOGGER.fine("Incorrecta, teclea de nuevo.");
                teclado.nextLine();
            }
        }
    }
}