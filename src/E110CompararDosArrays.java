void main() {

    int opcion;
    do {
        IO.println();
        IO.println("\n" + "\u001B[32m" + "-----MENÚ DE COMPARACIÓN DE ARRAYS-----" + "\u001B[0m");
        IO.println("\u001B[34m" + "1. Comparación de 2 arrays de números enteros." + "\u001B[0m");
        IO.println("\u001B[31m" + "2. Comparación de 2 arrays de números decimales." + "\u001B[0m");
        IO.println("\u001B[35m" + "3. Comparación de 2 arrays de valores (TRUE/FALSE)." + "\u001B[0m");
        IO.println("0. Salir del programa.");
        opcion = Integer.parseInt(IO.readln("\nElige la opción que quieras: "));
        switch (opcion) {
            case 1 -> {
                IO.println("\n" + "\u001B[34m" + "----------LISTA DE NÚMEROS ENTEROS----------" + "\u001B[0m");

                int n1 = Integer.parseInt(IO.readln("\n¿Cuántos números quieres introducir en la lista 1 de números enteros?\n")), n2 = Integer.parseInt(IO.readln("\n¿Cuántos números quieres introducir en la lista 2 de números enteros?\n"));

                int[] lista1 = new int[n1];
                int[] lista2 = new int[n2];

                if (n2 - n1 == 0) {

                    IO.println("\n" + "\u001B[34m" + "----COMIENZA LA LISTA 1 DE NÚMEROS ENTEROS----\n" + "\u001B[0m");
                    for (int i = 0; i < lista1.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la casilla %d de la lista 1 de números enteros.", i + 1));
                        lista1[i] = Integer.parseInt(IO.readln(" Introduce el número que quieras: "));
                    }

                    IO.println("\n" + "\u001B[34m" + "----COMIENZA LA LISTA 2 DE NÚMEROS ENTEROS----\n" + "\u001B[0m");
                    for (int i = 0; i < lista2.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la casilla %d de la lista 2 de números enteros.", i + 1));
                        lista2[i] = Integer.parseInt(IO.readln(" Introduce el número que quieras: "));
                    }

                    IO.print("\n" + "\u001B[34m" + "----COMIENZA LA COMPARACIÓN ENTRE LOS VALORES DE CADA CASILLA DE AMBAS LISTAS----\n" + "\u001B[0m");
                    for (int i = 0; i < lista1.length; i++) { //En este caso eligo lista1.length como podría usar el lista2.length o una variable con la longitud, como en los demás tipos de array (decimal y booleano).
                        IO.print(String.format((lista1[i] == lista2[i]) ? "\nEn la posición %d, el valor \"%d\" de la lista 1 es IGUAL que el valor \"%d\" de la lista 2." : (lista1[i] > lista2[i]) ? "\nEn la posición %d, el valor \"%d\" de la lista 1 es MAYOR que el valor \"%d\" de la lista 2" : "\nEn la posición %d, el valor \"%d\" de la lista 1 es MENOR que el valor \"%d\" de la lista 2", i + 1, lista1[i], lista2[i]));
                    }
                } else if (lista1.length > lista2.length) {

                    IO.println("\n" + "\u001B[34m" + "----COMIENZA LA LISTA 1 DE NÚMEROS ENTEROS----\n" + "\u001B[0m");
                    for (int i = 0; i < lista1.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la casilla %d de la lista 1 de números enteros.", i + 1));
                        lista1[i] = Integer.parseInt(IO.readln(" Introduce el número que quieras: "));
                    }

                    IO.println("\n" + "\u001B[34m" + "----COMIENZA LA LISTA 2 DE NÚMEROS ENTEROS----\n" + "\u001B[0m");
                    for (int i = 0; i < lista2.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la casilla %d de la lista 2 de números enteros.", i + 1));
                        lista2[i] = Integer.parseInt(IO.readln(" Introduce el número que quieras: "));
                    }

                    IO.print("\n" + "\u001B[34m" + "----COMIENZA LA COMPARACIÓN ENTRE LOS VALORES DE CADA CASILLA DE AMBAS LISTAS----\n" + "\u001B[0m");
                    for (int i = 0; i < lista1.length; i++) {
                        try {
                            IO.print(String.format((lista1[i] == lista2[i]) ? "\nEn la posición %d, el valor \"%d\" de la lista 1 es IGUAL que el valor \"%d\" de la lista 2." : (lista1[i] > lista2[i]) ? "\nEn la posición %d, el valor \"%d\" de la lista 1 es MAYOR que el valor \"%d\" de la lista 2" : "\nEn la posición %d, el valor \"%d\" de la lista 1 es MENOR que el valor \"%d\" de la lista 2", (i + 1), lista1[i], lista2[i]));
                        } catch (ArrayIndexOutOfBoundsException e) {
                            IO.print("\nNO EXISTEN MÁS CASILLAS EN LA LISTA 2 CON LAS QUE PODER COMPARAR VALORES");
                        }
                    }

                } else {

                    IO.println("\n" + "\u001B[34m" + "----COMIENZA LA LISTA 1 DE NÚMEROS ENTEROS----\n" + "\u001B[0m");
                    for (int i = 0; i < lista1.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la casilla %d de la lista 1 de números enteros.", i + 1));
                        lista1[i] = Integer.parseInt(IO.readln(" Introduce el número que quieras: "));
                    }

                    IO.println("\n" + "\u001B[34m" + "----COMIENZA LA LISTA 2 DE NÚMEROS ENTEROS----\n" + "\u001B[0m");
                    for (int i = 0; i < lista2.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la casilla %d de la lista 2 de números enteros.", i + 1));
                        lista2[i] = Integer.parseInt(IO.readln(" Introduce el número que quieras: "));
                    }

                    IO.print("\n" + "\u001B[34m" + "----COMIENZA LA COMPARACIÓN ENTRE LOS VALORES DE CADA CASILLA DE AMBAS LISTAS----\n" + "\u001B[0m");
                    for (int i = 0; i < lista2.length; i++) {
                        try {
                            IO.print(String.format((lista1[i] == lista2[i]) ? "\nEn la posición %d, el valor \"%d\" de la lista 1 es IGUAL que el valor \"%d\" de la lista 2." : (lista1[i] > lista2[i]) ? "\nEn la posición %d, el valor \"%d\" de la lista 1 es MAYOR que el valor \"%d\" de la lista 2" : "\nEn la posición %d, el valor \"%d\" de la lista 1 es MENOR que el valor \"%d\" de la lista 2", i + 1, lista1[i], lista2[i]));
                        } catch (ArrayIndexOutOfBoundsException e) {
                            IO.print("\nNO EXISTEN MÁS CASILLAS EN LA LISTA 1 CON LAS QUE PODER COMPARAR VALORES");
                        }
                    }
                }
            }
            case 2 -> {
                IO.println("\n" + "\u001B[31m" + "----------LISTA DE NÚMEROS DECIMALES----------" + "\u001B[0m");
                int ndecimales1 = Integer.parseInt(IO.readln("\n\n¿Cuántos números quieres introducir en la lista 1 de numeros decimales?\n")), ndecimales2 = Integer.parseInt(IO.readln("\n¿Cuántos números quieres introducir en la lista 2 de numeros decimales?\n"));

                double[] lista1decimales = new double[ndecimales1];
                double[] lista2decimales = new double[ndecimales2];

                if (ndecimales1 - ndecimales2 == 0) {
                    IO.println("\n" + "\u001B[31m" + "----COMIENZA LA LISTA 1 DE NÚMEROS DECIMALES----\n" + "\u001B[0m");
                    for (int i = 0; i < lista1decimales.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la posición %d. ", i + 1));
                        lista1decimales[i] = Double.parseDouble(IO.readln("Introduce el número decimal que quieras: "));
                    }

                    IO.println("\n" + "\u001B[31m" + "----COMIENZA LA LISTA 2 DE NÚMEROS DECIMALES----\n" + "\u001B[0m");
                    for (int i = 0; i < lista2decimales.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la posición %d. ", i + 1));
                        lista2decimales[i] = Double.parseDouble(IO.readln("Introduce el número decimal que quieras: "));
                    }

                    IO.print("\n" + "\u001B[31m" + "----COMIENZA LA COMPARACIÓN ENTRE LOS VALORES DE CADA CASILLA DE AMBAS LISTAS----\n" + "\u001B[0m");
                    for (int i = 0; i < lista1decimales.length; i++) {
                        IO.print(String.format((lista1decimales[i] == lista2decimales[i]) ? "\nEn la posición %d, el valor \"%.2f\" de la lista 1 es IGUAL que el valor %.2f de la lista 2." : (lista1decimales[i] > lista2decimales[i]) ? "\nEn la posición %d, el valor \"%.2f\" de la lista 1 es MAYOR que el valor \"%.2f\" de la lista 2" : "\nEn la posición %d, el valor \"%.2f\" de la lista 1 es MENOR que el valor \"%.2f\" de la lista 2", i + 1, lista1decimales[i], lista2decimales[i]));
                    }
                } else if (lista1decimales.length > lista2decimales.length) {
                    IO.println("\n" + "\u001B[31m" + "----COMIENZA LA LISTA 1 DE NÚMEROS DECIMALES----\n" + "\u001B[0m");
                    for (int i = 0; i < lista1decimales.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la posición %d. ", i + 1));
                        lista1decimales[i] = Double.parseDouble(IO.readln("Introduce el número decimal que quieras: "));
                    }

                    IO.println("\n" + "\u001B[31m" + "----COMIENZA LA LISTA 2 DE NÚMEROS DECIMALES----\n" + "\u001B[0m");
                    for (int i = 0; i < lista2decimales.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la posición %d. ", i + 1));
                        lista2decimales[i] = Double.parseDouble(IO.readln("Introduce el número decimal que quieras: "));
                    }

                    IO.print("\n" + "\u001B[31m" + "----COMIENZA LA COMPARACIÓN ENTRE LOS VALORES DE CADA CASILLA DE AMBAS LISTAS----\n" + "\u001B[0m");
                    for (int i = 0; i < lista1decimales.length; i++) {
                        try {
                            IO.print(String.format((lista1decimales[i] == lista2decimales[i]) ? "\nEn la posición %d, el valor \"%.2f\" de la lista 1 es IGUAL que el valor \"%.2f\" de la lista 2." : (lista1decimales[i] > lista2decimales[i]) ? "\nEn la posición %d, el valor \"%.2f\" de la lista 1 es MAYOR que el valor \"%.2f\" de la lista 2" : "\nEn la posición %d, el valor \"%.2f\" de la lista 1 es MENOR que el valor \"%.2f\" de la lista 2", i + 1, lista1decimales[i], lista2decimales[i]));
                        } catch (ArrayIndexOutOfBoundsException e) {
                            IO.print("\nNO EXISTEN MÁS CASILLAS EN LA LISTA 2 CON LAS QUE PODER COMPARAR VALORES");
                        }
                    }
                } else {
                    IO.println("\n" + "\u001B[31m" + "----COMIENZA LA LISTA 1 DE NÚMEROS DECIMALES----\n" + "\u001B[0m");
                    for (int i = 0; i < lista1decimales.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la posición %d. ", i + 1));
                        lista1decimales[i] = Double.parseDouble(IO.readln("Introduce el número decimal que quieras: "));
                    }

                    IO.println("\n" + "\u001B[31m" + "----COMIENZA LA LISTA 1 DE NÚMEROS DECIMALES----\n" + "\u001B[0m");
                    for (int i = 0; i < lista2decimales.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la posición %d. ", i + 1));
                        lista2decimales[i] = Double.parseDouble(IO.readln("Introduce el número decimal que quieras: "));
                    }

                    IO.print("\n" + "\u001B[31m" + "----COMIENZA LA COMPARACIÓN ENTRE LOS VALORES DE CADA CASILLA DE AMBAS LISTAS----\n" + "\u001B[0m");
                    for (int i = 0; i < lista2decimales.length; i++) {
                        try {
                            IO.print(String.format((lista1decimales[i] == lista2decimales[i]) ? "\nEn la posición %d, el valor \"%.2f\" de la lista 1 es IGUAL que el valor \"%.2f\" de la lista 2." : (lista1decimales[i] > lista2decimales[i]) ? "\nEn la posición %d, el valor \"%.2f\" de la lista 1 es MAYOR que el valor \"%.2f\" de la lista 2" : "\nEn la posición %d, el valor \"%.2f\" de la lista 1 es MENOR que el valor \"%.2f\" de la lista 2", i + 1, lista1decimales[i], lista2decimales[i]));
                        } catch (ArrayIndexOutOfBoundsException e) {
                            IO.print("\nNO EXISTEN MÁS CASILLAS EN LA LISTA 1 CON LAS QUE PODER COMPARAR VALORES");
                        }
                    }
                }
            }
            case 3 -> {
                IO.println("\n" + "\u001B[35m" + "----------LISTA DE VALORES (TRUE/FALSE)----------" + "\u001B[0m");
                int nbooleans1 = Integer.parseInt(IO.readln("\n¿Cuántos valores quieres introducir en la lista 1 de valores (TRUE/FALSE)?\n")), nbooleans2 = Integer.parseInt(IO.readln("\n¿Cuántos valores quieres introducir en la lista 2 de valores (TRUE/FALSE)?\n"));

                boolean[] verdaderoFalso1 = new boolean[nbooleans1];
                boolean[] verdaderoFalso2 = new boolean[nbooleans2];

                if (nbooleans1 - nbooleans2 == 0) {

                    IO.println("\n" + "\u001B[35m" + "----COMIENZA LA LISTA 1 DE VALORES (TRUE/FALSE)----\n" + "\u001B[0m");
                    for (int i = 0; i < verdaderoFalso1.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la casilla %d de la lista 1 de valores (TRUE/FALSE).", i + 1));
                        verdaderoFalso1[i] = Boolean.parseBoolean(IO.readln(" Introduce el valor que quieras: ").trim());
                    }

                    IO.println("\n" + "\u001B[35m" + "----COMIENZA LA LISTA 2 DE VALORES (TRUE/FALSE)----\n" + "\u001B[0m");
                    for (int i = 0; i < verdaderoFalso2.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la casilla %d de la lista 2 de valores (TRUE/FALSE).", i + 1));
                        verdaderoFalso2[i] = Boolean.parseBoolean(IO.readln(" Introduce el valor que quieras: ").trim());
                    }

                    IO.print("\n" + "\u001B[35m" + "----COMIENZA LA COMPARACIÓN ENTRE LOS VALORES DE CADA CASILLA DE AMBAS LISTAS----\n" + "\u001B[0m");
                    for (int i = 0; i < verdaderoFalso1.length; i++) {
                        IO.print(String.format((verdaderoFalso1[i] == verdaderoFalso2[i]) ? "\nEn la posición %d, el valor \"%b\" de la lista 1 es IGUAL que el valor \"%b\" de la lista 2." : "\nEn la posición %d, el valor \"%b\" de la lista 1 es DIFERENTE al valor \"%b\" de la lista 2.", i + 1, verdaderoFalso1[i], verdaderoFalso2[i]));
                    }
                } else if (verdaderoFalso1.length > verdaderoFalso2.length) {

                    IO.println("\n" + "\u001B[35m" + "----COMIENZA LA LISTA 1 DE VALORES (TRUE/FALSE)----\n" + "\u001B[0m");
                    for (int i = 0; i < verdaderoFalso1.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la casilla %d de la lista 1 de valores (TRUE/FALSE).", i + 1));
                        verdaderoFalso1[i] = Boolean.parseBoolean(IO.readln(" Introduce el valor que quieras: ").trim());
                    }

                    IO.println("\n" + "\u001B[35m" + "----COMIENZA LA LISTA 2 DE VALORES (TRUE/FALSE)----\n" + "\u001B[0m");
                    for (int i = 0; i < verdaderoFalso2.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la casilla %d de la lista 2 de valores (TRUE/FALSE).", i + 1));
                        verdaderoFalso2[i] = Boolean.parseBoolean(IO.readln(" Introduce el valor que quieras: ").trim());
                    }

                    IO.print("\n" + "\u001B[35m" + "----COMIENZA LA COMPARACIÓN ENTRE LOS VALORES DE CADA CASILLA DE AMBAS LISTAS----\n" + "\u001B[0m");
                    for (int i = 0; i < verdaderoFalso1.length; i++) {
                        try {
                            IO.print(String.format((verdaderoFalso1[i] == verdaderoFalso2[i]) ? "\nEn la posición %d, el valor \"%b\" de la lista 1 es IGUAL que el valor \"%b\" de la lista 2." : "\nEn la posición %d, el valor \"%b\" de la lista 1 es DIFERENTE al valor \"%b\" de la lista 2.", i + 1, verdaderoFalso1[i], verdaderoFalso2[i]));
                        } catch (ArrayIndexOutOfBoundsException e) {
                            IO.print("\nNO EXISTEN MÁS CASILLAS EN LA LISTA 2 CON LAS QUE PODER COMPARAR VALORES");
                        }
                    }
                } else {
                    IO.println("\n" + "\u001B[35m" + "----COMIENZA LA LISTA 1 DE VALORES (TRUE/FALSE)----\n" + "\u001B[0m");
                    for (int i = 0; i < verdaderoFalso1.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la casilla %d de la lista 1 de valores (TRUE/FALSE).", i + 1));
                        verdaderoFalso1[i] = Boolean.parseBoolean(IO.readln(" Introduce el valor que quieras: ").trim());
                    }

                    IO.println("\n" + "\u001B[35m" + "----COMIENZA LA LISTA 2 DE VALORES (TRUE/FALSE)----\n" + "\u001B[0m");
                    for (int i = 0; i < verdaderoFalso2.length; i++) {
                        IO.print(String.format("Actualmente te encuentras en la casilla %d de la lista 2 de valores (TRUE/FALSE).", i + 1));
                        verdaderoFalso2[i] = Boolean.parseBoolean(IO.readln(" Introduce el valor que quieras: ").trim());
                    }

                    IO.print("\n" + "\u001B[35m" + "----COMIENZA LA COMPARACIÓN ENTRE LOS VALORES DE CADA CASILLA DE AMBAS LISTAS----\n" + "\u001B[0m");
                    for (int i = 0; i < verdaderoFalso2.length; i++) {
                        try {
                            IO.print(String.format((verdaderoFalso1[i] == verdaderoFalso2[i]) ? "\nEn la posición %d, el valor \"%b\" de la lista 1 es IGUAL que el valor \"%b\" de la lista 2." : "\nEn la posición %d, el valor \"%b\" de la lista 1 es DIFERENTE al valor \"%b\" de la lista 2.", i + 1, verdaderoFalso1[i], verdaderoFalso2[i]));
                        } catch (ArrayIndexOutOfBoundsException e) {
                            IO.print("\nNO EXISTEN MÁS CASILLAS EN LA LISTA 1 CON LAS QUE PODER COMPARAR VALORES");
                        }
                    }
                }
            }
        }
    } while (opcion != 0);
    IO.println("\nADIOSSS");
}