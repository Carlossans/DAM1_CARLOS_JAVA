void main() {
    String texto = IO.readln("\nIntroduce una palabra o frase: ").toLowerCase().trim();

    IO.println(String.format("\nLa palabra/frase \"%s\" tiene %d consonantes.", texto, contarConsonantes(texto)));
}

int contarConsonantes(String texto) {
    int totalConsonantes = 0, posicion = 0;

    for (int i = 0; i < texto.length(); i++) {
        char c = texto.charAt(i);

        if (c != ' ') {
            posicion++;
        }

        if ((c >= 'b' & c <= 'z' & c != 'e' & c != 'i' & c != 'o' & c != 'u') | c == 'ñ') {
            IO.println(String.format("\nConsonante '%s' en la posición %d", c, posicion));
            totalConsonantes++;
        }
    }
    return totalConsonantes;
}
