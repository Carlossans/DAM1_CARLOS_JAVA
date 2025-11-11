void main() {

    String texto = IO.readln("\nIntroduce una palabra: ").toLowerCase().trim();

    IO.println(String.format("\nLa palabra/frase " + "%s" + " tiene %d consonantes", texto, contarConsonantes(texto)));
}

int contarConsonantes(String texto) {
    int totalConsonantes = 0;

    for (int i = 0; i < texto.length(); i++) {
        char c = texto.charAt(i);
        if (c >= 'b' & c <= 'z' & c != 'e' & c != 'i' & c != 'o' & c != 'u' & c != 'é' & c != 'í' & c != 'ó' & c != 'ú' & c != 'ü' | c == 'ñ') {
            totalConsonantes++;
        }
    }
    return totalConsonantes;
}