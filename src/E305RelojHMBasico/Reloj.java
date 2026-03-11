package E305RelojHMBasico;

public abstract class Reloj implements Comparable<Reloj>, Cloneable{
    private int h;
    private int m;

    public Reloj() {
        // Se podría hacer así:
        // h = 8;
        // m = 15;

        // Pero esto sería mejor, llamar a otro costructor sobrecargado:
        this(8, 15);
    }

    public Reloj(int h, int m) {
        this.h = h;
        this.m = m;

        normalizar();
    }

    public Reloj(int totalMinutos) {
        // Se podría hacer así:
        // h = 0;
        // m = totalMinutos;
        // normalizar();

        // Pero esto sería mejor, llamar a otro costructor sobrecargado:
        this(0, totalMinutos);
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public abstract String toString();
        //return String.format("%02d:%02d", h, m);


    public boolean equals(Object obj) {
        // Se comprueba si obj es null. Si lo es, consideramos que somos distintos.
        if (obj == null) return false;

        // Se comprueba si obj es de la clase Reloj. Si NO lo es, consideramos que somos distintos.
        if (!(obj instanceof Reloj)) return false;

        Reloj otro = (Reloj) obj;

        // Por último, hacemos la comprobación de igualdad en sí:
        return ((this.h == otro.h) && (this.m == otro.m));

        // Alternativa:
        // return ((this.h == ((Reloj) obj).h) && (this.m == ((Reloj) obj).m));
    }

//    public Reloj clone() {
//        Reloj clon = new Reloj();
//
//        clon.h = this.h;
//        clon.m = this.m;
//
//        return clon;
//
//        // Alternativa:
//        // return new Reloj(this.h, this.m);
//    }

    private void normalizar() {
        // Alternativa 1, más sencilla pero menos eficiente:

        while (m <   0) { h--; m = m + 60; }
        while (m >= 60) { h++; m = m - 60; }

        while (h <   0) { h = h + 24; }
        while (h >= 24) { h = h - 24; }



        // Alternativa 2, más eficiente pero más compleja:

        //if (m < 0) {
        //     h = -1 + h + m / 60;
        //     m = 60 + m % 60;
        //}
        //
        //if (m >= 60) {
        //     h = h + m / 60;
        //     m = m % 60;
        //}
        //
        //if (h < 0) {
        //     h = 24 + h % 24;
        //}
        //
        //if (h >= 24) {
        //     h = h % 24;
        //}
    }

    private int totalMinutos() {
        return 60 * h + m;
    }

    public void tick() {
        sumarMinutos(1);
    }

    public void sumarMinutos(int minutos) {
        m = m + minutos;

        normalizar();
    }

    public void restarMinutos(int minutos) {
        m = m - minutos;

        normalizar();
    }

    public int diferenciaMinutos(Reloj otro) {
        int diferencia = Math.abs(this.totalMinutos() - otro.totalMinutos());

        return diferencia;
    }

//    public Reloj diferenciaReloj(Reloj otro) {
//        int diferenciaMinutos = this.diferenciaMinutos(otro);
//
//        Reloj diferenciaReloj = new Reloj(diferenciaMinutos);
//
//        return diferenciaReloj;
//    }

    @Override
    public int compareTo(Reloj otro) {
        return Integer.compare(this.totalMinutos(), otro.totalMinutos());
    }
}
