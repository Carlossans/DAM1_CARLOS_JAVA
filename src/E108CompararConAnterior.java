void main() {
    int n = Integer.parseInt(IO.readln("\n¿Cuántos números decimales quieres introducir?\n"));
    double[] decimales1 = new double [n];

    for (int i = 0; i <decimales1.length; i++) {
        decimales1[i] = Double.parseDouble(IO.readln("\nActualmente te encuentras en la casilla " + (i + 1) + ". Introduce el número decimal que quieras: "));
    }

    IO.println("\u001B[32m" + "\n----COMIENZA LA COMPARACIÓN DE LOS NÚMEROS----" + "\u001B[0m");
    for (int i = 0; i < decimales1.length; i++) {
        try {
            IO.println(String.format(
                    (decimales1[i + 1] == decimales1[i]) ? "\nEl número %.2f, en la casilla %d es IGUAL que el número %.2f, en la casilla %d." : (decimales1[i + 1] > decimales1[i]) ? "\nEl número %.2f, en la casilla %d es MAYOR que el número %.2f, en la casilla %d." : "\nEl número %.2f, en la casilla %d es MENOR que el número %.2f, en la casilla %d."
                    , decimales1[i + 1], i + 2, decimales1[i], i + 1));
        } catch (ArrayIndexOutOfBoundsException enrique) {
            IO.println("\nFIN");
        }
    }

}