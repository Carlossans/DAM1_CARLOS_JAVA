void main() {
    int h1 = Integer.parseInt(IO.readln("\nIntroduce hora 1: ")), m1 = Integer.parseInt(IO.readln("\nIntroduce el minuto 1: ")), h2 = Integer.parseInt(IO.readln("\nIntroduce hora 2: ")), m2 = Integer.parseInt(IO.readln("\nIntroduce el minuto 2: "));


    if (h1 > h2) {
        IO.println(String.format("\nLa diferencia es de %d:%d.", h1 - h2, m1 - m2));
    } else {
        IO.println(String.format("\nLa diferencia es de %d:%d.", h2 - h1, m2 - m1));
    }
}