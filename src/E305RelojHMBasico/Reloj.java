package E305RelojHMBasico;

public class Reloj {

    private int h;
    private int m;

    public Reloj() {
        this.h = 8;
        this.m = 15;
    }

    public Reloj(int totalMinutos) {
        this.h = totalMinutos / 60;
        this.m = totalMinutos % 60;
    }

    public Reloj(int h, int m) {
        int total = h * 60 + m;
        formatearHora(total);

    }

    public void formatearHora(int totalMinutos) {
        int minutosDia = 24 * 60; //minutos totales del día
        totalMinutos = totalMinutos %  minutosDia; //Ajustas si los minutos superan los de un día completo
        if (totalMinutos < 0) {
            totalMinutos = totalMinutos + minutosDia;
        }
        this.h = totalMinutos / 60;
        this.m = totalMinutos % 60;
    }


    public void tick() {
        sumarMinutos(1);
    }

    public void sumarMinutos(int minutos) {
        int total = h * 60 + m + minutos;
        formatearHora(total);
    }

    public void restarMinutos(int minutos) {
        int total = h * 60 + m - minutos;
        formatearHora(total);
    }

    public int calcularDiferenciaMinutos(Reloj otro) {
        int t1 = this.h * 60 + this.m;
        int t2 = otro.h * 60 + otro.m;
        return t2 - t1;
    }

    public Reloj calcularDiferenciaReloj(Reloj otro) {
        int diferencia = Math.abs(calcularDiferenciaMinutos(otro));
        return new Reloj(diferencia);
    }

    public String toString() {
        return String.format("%02d:%02d", h, m);
    }
}

