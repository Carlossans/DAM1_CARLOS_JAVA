String darVueltaFrase(String texto) {
    int longitud = texto.length();

    for (int i = 0; i < texto.length(); i++) {
        IO.print(texto.charAt(longitud - 1));
        longitud--;
    }
    return texto;
}

void main() {

    String texto = IO.readln("\nIntroduce una palabra: ").trim();

    darVueltaFrase(texto);
}