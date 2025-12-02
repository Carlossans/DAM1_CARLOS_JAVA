void main() {
    double[] vector = {4, 3, 6 ,2};
    double sumaTotal = 0;

    for (double numActual : vector) {
        sumaTotal = sumaTotal + (Math.pow(numActual, 2));
    }

    IO.println(sumaTotal);

    double modulo = Math.sqrt(sumaTotal);

    IO.println("\nEl modulo del vector es: " + modulo);
}