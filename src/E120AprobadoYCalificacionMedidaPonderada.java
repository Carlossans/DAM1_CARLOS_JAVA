boolean comprobarSiPuedeAprobar(double calificacion) {
    return (calificacion < 4);
}

double calcularMedia(double calificacion, double peso) {
    double media = 0;

   media = media + (calificacion * peso);

    return media;
}


void main() {
    boolean aprueba;
    int contador = 0;
    double[] calificaciones = {9.0, 5.23, 4.5, 4.0, 3.0};
    double[] pesos = {0.15, 0.20, 0.25, 0.30, 0.10};
    double mediaTotal = 0;


    for (double calificacion : calificaciones) {
        if (comprobarSiPuedeAprobar(calificacion)) contador++;
    }
    aprueba = (contador < 1);

    IO.println(
            (aprueba) ? "\nEl alumno PUEDE aprobar DE MOMENTO... " : "\nEl alumno NO PUEDE aprobar"
    );

    if (aprueba) {
        for (int i = 0; i < calificaciones.length; i++) {
            mediaTotal = mediaTotal + calcularMedia(calificaciones[i], pesos[i]);
        }

        IO.println(String.format(
                (mediaTotal >= 5.00) ? "\nApruebas con un %.2f" : "\nAl final suspendes y se te queda la media en un %.2f"
        , mediaTotal));
    }
}