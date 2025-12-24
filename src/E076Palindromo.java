void main() {
    String texto = IO.readln("\nIntroduce una palabra y comprobaré si es un palíndromo: ").toLowerCase();

    if (esPalindromo(texto)) {
        IO.println("\nEs un palíndromo");
    } else {
        IO.println("\nNo es un palíndromo");
    }

}
boolean esPalindromo(String texto) {
    int inicio = 0, fin = texto.length() - 1;

    do {
        if (texto.charAt(inicio) != texto.charAt(fin)) {
            return false;
        }
        inicio ++;
        fin--;
    } while (inicio < fin);
    return true;
}
