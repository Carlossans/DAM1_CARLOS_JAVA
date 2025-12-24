int encuentraPosicionEnElTexto(String textoBuscado, String textoPrincipal) {

    int longitudPrincipal = textoPrincipal.length();
    int longitudBuscado = textoBuscado.length();

    for (int i = 0; i <= longitudPrincipal - longitudBuscado; i++) {
        boolean encontrado = true;

        for (int j = 0; j < longitudBuscado; j++) {
            if (textoPrincipal.charAt(i + j) != textoBuscado.charAt(j)) {
                encontrado = false;
                break;
            }
        }
        if (encontrado) {
            return i;
        }
    }
    return -1;
}

void main() {

    String textoPrincipal = IO.readln("\nIntroduce el texto principal: ");
    String textoBuscado = IO.readln("\nIntroduce el texto/frase que quieras buscan en el texto principal: ");

    int pos = encuentraPosicionEnElTexto(textoBuscado, textoPrincipal);

    if (encuentraPosicionEnElTexto(textoBuscado, textoPrincipal) != -1) {
        IO.println(String.format("\nEl texto %s se ha encontrado en la posición %d", textoBuscado, pos));
    } else {
        IO.println(String.format("\nEl texto %s no se ha encontrado", textoBuscado));
    }
}
