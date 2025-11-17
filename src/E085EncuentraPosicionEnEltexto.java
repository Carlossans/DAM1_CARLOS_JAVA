int encuentraPosicionEnElTexto(String textoBuscado, String textoPrincipal) {
    if (textoBuscado.isEmpty()) {
        return 0;
    }
    
    int longitudBuscada = textoBuscado.length();
    int longitudPrincipal = textoPrincipal.length();
    
    for (int i = 0; i <= longitudPrincipal - longitudBuscada; i++) {
        boolean encontrado = true;
        
        for (int j = 0; j < longitudBuscada; j++) {
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
    String textoBuscado = IO.readln("\nIntroduce el texto que quieres buscar en el texto principal: ");
    
    int posicion = encuentraPosicionEnElTexto(textoBuscado, textoPrincipal);
    
    if (posicion != -1) {
        System.out.println("El texto '" + textoBuscado + "' se encontró en la posición: " + posicion);
        IO.println(String.format("El texto %s se encontró en la posición", textoBuscado, posicion));
    } else {
        IO.println(String.format("El texto %s no se ha encontrado en el texto", textoBuscado, posicion));
    }
}