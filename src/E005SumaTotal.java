/*void main() {
    int suma = 0;
    int respuesta = Integer.parseInt(IO.readln("¿Cuántos números quieres sumar?\n").trim().replaceAll("\\s" ,"" ));

    IO.println("Introduzca los números a continuación:\n");
    int numero = 0;
    for (int i = 1; i <= respuesta; i++) {
        numero = Integer.parseInt(IO.readln().trim().replaceAll("\\s" ,"" ));
        suma = suma + numero;
    }

    IO.println("El resultado de la suma es: " + suma);

}*/

import java.awt.image.ImageObserver;

void main() {
    int sumatotal = 0;
    int cantidad = 0;

    while (true) {
        try {
           cantidad = Integer.parseInt(IO.readln("¿Cuántos números quieres sumar?\n").trim().replaceAll("\\s", ""));
            break;
        } catch (NumberFormatException e) {
            IO.println("No se puede introducir texto, tiene que ser un número, inténtalo de nuevo.");
        }
    }

        IO.println("Introduce los números a sumar:");
        for (int i = 1; i <= cantidad; i++) {
            while (true) {
                try {
                    int numeros = Integer.parseInt(IO.readln().trim().replaceAll("\\s", ""));
                    sumatotal = sumatotal + numeros;
                    break;
                } catch (NumberFormatException e) {
                    IO.println("No se puede introducir texto, tiene que ser un número, inténtalo de nuevo.");
                }
            }
        }
        IO.println("El resultado de la suma es: " + sumatotal);
}
