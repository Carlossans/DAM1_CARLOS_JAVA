void main() {
    String confirmacion;
    int multiplo = 0;
    boolean valido;
    int modulo = 0;
    int compModulo = 0;


    multiplo = Integer.parseInt(IO.readln("\n¿Con que múltiplo quieres hacer la verificación: ").replaceAll("\\s" , ""));

    modulo = Integer.parseInt(IO.readln("\n¿Con que modulo quieres hacer la verificación: ").replaceAll("\\s" , ""));

    for (int i = 0; i < 50; i++) {
         compModulo = i % modulo;
        if (i % multiplo == 0) {
            confirmacion = "El número SÍ es múltiplo de " + multiplo;
        } else {
            confirmacion = "El número NO es múltiplo de " + multiplo;
        }
        IO.println(String.format("Vamos por el número %d " + i + " módulo %d es %d %s", i, modulo, compModulo, confirmacion));
    }
}