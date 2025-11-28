void main() {
    int n1 = Integer.parseInt(IO.readln("\n¿Cuántos números quieres introducir en la lista 1?\n")), n2 = java.lang.Integer.parseInt(IO.readln("\n¿Cuántos números quieres introducir en la lista 2?\n")), diferencia;
//
//    verdaderoFalso1 = java.lang.Integer.parseInt(IO.readln("\n¿Cuántos números quieres introducir en la lista 1 de valores(Verdadero/Falso)?\n")), verdaderoFalso2 = Integer.parseInt(IO.readln("\n¿Cuántos números quieres introducir en la lista de decimales 2?\n"));

    diferencia = (n1 > n2) ? n1 - n2 : (n2 > n1) ? n2 - n1 : 0;

    int[] lista1 = new int [n1];
    int[] lista2 = new int [n2];

    if (diferencia == 0) {

        IO.println("\n----COMIENZA LA LISTA 1 DE NÚMEROS ENTEROS----\n");
        for (int i = 0; i < lista1.length; i++) {
            IO.print(String.format("Actualmente te encuentras en la casilla %d de la lista de números enteros 1.", i + 1));
            lista1[i] = Integer.parseInt(IO.readln(" Introduce el número que quieras: "));
        }

        IO.println("\n----COMIENZA LA LISTA 2 DE NÚMEROS ENTEROS----\n");
        for (int i = 0; i < lista2.length; i++) {
            IO.print(String.format("Actualmente te encuentras en la casilla %d de la lista de números enteros 2.", i + 1));
            lista2[i] = Integer.parseInt(IO.readln(" Introduce el número que quieras: "));
        }

        IO.print("\n----COMIENZA LA COMPARACIÓN ENTRE LOS VALORES DE CADA CASILLA DE LOS ARRAYS----\n");
        for (int i = 0; i < lista1.length; i++) {
            IO.print(String.format(
                    (lista1[i] == lista2[i]) ? "\nLos valores de ambas casillas en la posición %d son IGUALES" : (lista1[i] > lista2[i]) ? "\nEn la posición %d el valor %d de la lista 1 es MAYOR que el valor %d de la lista 2" : "\nEn la posición %d el valor %d de la lista 1 es MENOR que el valor %d de la lista 2"
            , i + 1, lista1[i], lista2[i]));
        }
    } else if (lista1.length > lista2.length) {

        IO.println("\n----COMIENZA LA LISTA 1 DE NÚMEROS ENTEROS----\n");
        for (int i = 0; i < lista1.length; i++) {
            IO.print(String.format("Actualmente te encuentras en la casilla %d de la lista de números enteros 1.", i + 1));
            lista1[i] = Integer.parseInt(IO.readln(" Introduce el números que quieras: "));
        }

        IO.println("\n----COMIENZA LA LISTA 2 DE NÚMEROS ENTEROS----\n");
        for (int i = 0; i < lista2.length; i++) {
            IO.print(String.format("Acutalmente te encuentras en la casilla %d de la lista de números enteros 2.", i + 1));
            lista2[i] = Integer.parseInt(IO.readln(" Introduce el número que quieras: "));
        }

        IO.print("\n----COMIENZA LA COMPARACIÓN ENTRE LOS VALORES DE CADA CASILLA DE LOS ARRAYS----\n");
        for (int i = 0; i < lista1.length; i++) {
            try {
                IO.print(String.format(
                        (lista1[i] == lista2[i]) ? "\nLos valores de ambas casillas en la posición %d son IGUALES" : (lista1[i] > lista2[i]) ? "\nEn la posición %d el valor %d de la lista 1 es MAYOR que el valor %d de la lista 2" : "\nEn la posición %d el valor %d de la lista 1 es MENOR que el valor %d de la lista 2"
                        , (i + 1), lista1[i], lista2[i]));
            } catch (ArrayIndexOutOfBoundsException e) {
                IO.print("\nNO HAY VALOR EN ALGUNA DE LAS CASILLAS DE LA LISTA");
            }
        }

    } else if (lista2.length > lista1.length) {

        IO.println("\n----COMIENZA LA LISTA 1 DE NÚMEROS ENTEROS----\n");
        for (int i = 0; i < lista1.length; i++) {
            IO.print(String.format("Actualmente te encuentras en la casilla %d de la lista de números enteros 1.", i + 1));
            lista1[i] = Integer.parseInt(IO.readln(" Introduce el número que quieras: "));
        }

        IO.println("\n----COMIENZA LA LISTA 2 DE NÚMEROS ENTEROS----\n");
        for (int i = 0; i < lista2.length; i++) {
            IO.print(String.format("Actualmente te encuentras en la casilla %d de la lista de números enteros 2.", i + 1));
            lista2[i] = Integer.parseInt(IO.readln(" Introduce el número que quieras: "));
        }

        IO.print("\n----COMIENZA LA COMPARACIÓN ENTRE LOS VALORES DE CADA CASILLA DE LOS ARRAYS----\n");
        for (int i = 0; i < lista2.length; i++) {
            try {
                IO.print(String.format(
                        (lista1[i] == lista2[i]) ? "\nLos valores de ambas casillas en la posición %d son IGUALES" : (lista1[i] > lista2[i]) ? "\nEn la posición %d el valor %d de la lista 1 es MAYOR que el valor %d de la lista 2" : "\nEn la posición %d el valor %d de la lista 1 es MENOR que el valor %d de la lista 2"
                        , i + 1, lista1[i], lista2[i]));
            } catch (ArrayIndexOutOfBoundsException e) {
                IO.print("\nNO HAY VALOR EN ALGUNA DE LAS CASILLAS DE LA LISTA");
            }
        }
    }

//    diferencia = (decimales1 > decimales2) ? decimales1 - decimales2 : decimales2 - decimales1;
//
//    double[] verdaderoOFalso = new double [decimales1];
//    double[] falsoOVerdadero = new double [decimales2];


//    for ()  {
//
//    }


//    double[] listaDecimales1 = new double [decimales1];
//    double[] listaDecimales2 = new double[decimales2];
//
//    boolean[] realOrFake = new boolean [verdaderoFalso1];
//    boolean[] verdaderoOFalso = new boolean [verdaderoFalso2];


//    for (int i = 0; i < lista1.length; i++) {
//        IO.print(String.format("\nAcutalmente te encuentras en la casilla %d de la lista de número enteros 1.", i + 1));
//        lista1[i] = Integer.parseInt(IO.readln(" Introduce el número que quieras: "));
//    }
//
//    for (int i = 0; i < lista2.length; i++) {
//        IO.print(String.format("\nAcutalmente te encuentras en la casilla %d de la lista de número enteros 2.", i + 1));
//        lista2[i] = Integer.parseInt(IO.readln(" Introduce el número que quieras: "));
//    }



//    if (lista1.length < lista2.length) {
//        longitud = lista2.length;
//    }

//    for () {}






























//    for (int i = 0; i < lista1.length; i++) {
//        IO.println(String.format(
//                (lista1[i] == lista2[i]) ? "\nLos valores de la casilla %d son iguales" : (lista1[i] > lista2[i]) ? "\nEl valor de la casilla %d de la lista1 es mayor" : "\nEl valor de la casilla %d de la lista2 es mayor"
//        , i + 1));
//    }
//
//    IO.println("\n");
//    for (int i = 0; i < decimales1.length; i++) {
//        IO.println(String.format(
//                (decimales1[i] == decimales2[i]) ? "\nLos valores de la casilla %d son iguales" : (decimales1[i] > decimales2[i]) ? "\nEl valor de la casilla %d de la lista1 es mayor" : "\nEl valor de la casilla %d de la lista2 es mayor"
//                , i + 1));
//    }
//
//    IO.println("\n");
//    for (int i = 0; i < realOrFake.length; i++) {
//        IO.println(String.format(
//                (realOrFake[i] == verdaderoOFalso[i]) ? "\nLos contenidos de la casilla " + (i + 1) + " son iguales" : "\nLos contenidos de la casilla " + (i + 1) + " son distintos"
//        , i + 1));
//    }

}