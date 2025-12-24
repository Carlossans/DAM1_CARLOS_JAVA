void main() throws InterruptedException{
    char letra;
    long potencia = 1;
    boolean valido = true;

    do {
        do {
            letra = IO.readln("\nIntroduce una letra:").replaceAll("\\s", "").toLowerCase().charAt(0);

            if (letra == 's') {
                IO.println("\n" + potencia);
                potencia = potencia * 2;
                valido = true;
            } else if (letra == 'n') {
                IO.println("\nSaliendo del programa ...\n");
                valido = true;
                Thread.sleep(1500);
                return;
            } else {
                IO.println("\nNO VÁLIDO, TIENES QUE INTRODUCIR UNA S o N, INTENTALO DE NUEVO.");
                valido = false;
            }
        }while (!valido);
    } while (letra == 's');
}