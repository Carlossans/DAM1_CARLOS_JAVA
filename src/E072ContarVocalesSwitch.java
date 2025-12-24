boolean esVocal(char caracter) {
    caracter = Character.toLowerCase(caracter);

    return switch (caracter) {
        case 'a', 'e', 'i', 'o', 'u', 'á', 'é', 'í', 'ó', 'ú', 'ü' -> true;
        default ->
        false;
    };
}

private int contarVocales(String texto) {
    int contadorVocales = 0;

    for (int pos = 0; pos < texto.length(); pos++) {
        char c = texto.charAt(pos);
        if (esVocal(c)) contadorVocales++;
    }

    return contadorVocales;
}

void main() {
    IO.println("Introduzca el texto:");
    String texto = IO.readln();

    IO.println(String.format("El string tiene %d vocales.", contarVocales(texto)));
}
