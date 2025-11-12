boolean esVocal(char caracter) {
    caracter = Character.toLowerCase(caracter);

    switch (caracter) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
        case 'á':
        case 'é':
        case 'í':
        case 'ó':
        case 'ú':
            return true;
        default:
            return false;
    }
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
