void main() {
    int nAsteriscos = 0;
    boolean valido;

    nAsteriscos = Integer.parseInt(IO.readln("\nIntroduce la cantidad de asteriscos que quieres que tenga cada lado del cuadrado: ").replaceAll("\\s" , ""));

    for (int i = 1; i <= nAsteriscos; i++) {
        IO.print("*");
    }
}