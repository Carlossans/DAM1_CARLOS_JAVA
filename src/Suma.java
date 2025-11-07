void main() {
    int Cantidad, SumaTotal= 0;

    while (true) {
        try {
            Cantidad = Integer.parseInt(IO.readln("\n¿Cuantos números quieres sumar?\n").trim().replaceAll("\\s" , ""));
            break;
        }catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, TIENES QUE INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO\n");
        }
    }

    IO.println("\nIntroduce los números que quieres sumar\n");
    for (int i = 1; i <= Cantidad; i++) {
        while (true) {
            try {
                int Numeros = Integer.parseInt(IO.readln().trim().replaceAll("\\s" , ""));
                SumaTotal = SumaTotal + Numeros;
                break;
            }catch (NumberFormatException e ) {
                IO.println("\nFORMATO NO VÁLIDO, TIENES QUE INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO\n");
            }
        }
    }
    IO.println("El resultado de la suma total es " + SumaTotal);
}