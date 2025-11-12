void main() {
    String texto = IO.readln("\nIntroduce una palabra y comprobaré si es un palíndromo: ");

    if (esPalindromo(texto)) {
        IO.println("\nEs un palíndromo");
    } else {
        IO.println("\nNo es un palíndromo");
    }

}
boolean esPalindromo(String texto) {
    String invertida = new StringBuilder(texto).reverse().toString();


    return (invertida == texto);
}
