package E305RelojHMBasico;

public class Reloj {

    private int totalMinutos;

    public Reloj() {
        this(8, 15);
    }

    public Reloj(int h, int m) {
        this(h * 60 + m);

    }

    public Reloj(int totalDeMinutos) {
        this.totalMinutos = totalDeMinutos;
        formatearHora(totalMinutos);
    }

    public void formatearHora(int totalMinutos) {
        this.totalMinutos = totalMinutos;
        ajustarExcesos();
    }

    public void ajustarExcesos() {
        int minutosDia = 24 * 60;
        totalMinutos = totalMinutos % minutosDia;
        if (totalMinutos < 0) {
            totalMinutos = totalMinutos + minutosDia;
        }
    }

    public void tick() {
        sumarMinutos(1);
    }

    public void sumarMinutos(int minutos) {
        totalMinutos = totalMinutos + minutos;
        formatearHora(totalMinutos);
    }

    public void restarMinutos(int minutos) {
        totalMinutos = totalMinutos - minutos;
        formatearHora(totalMinutos);
    }

    public int calcularDiferenciaMinutos(Reloj otro) {
        return otro.totalMinutos - this.totalMinutos;
    }

    public Reloj calcularDiferenciaReloj(Reloj otro) {
        int diferencia = Math.abs(calcularDiferenciaMinutos(otro));
        return new Reloj(diferencia);
    }

    public String toString() {
        int h = totalMinutos / 60;
        int m = totalMinutos % 60;
        return String.format("%02d:%02d", h, m);
    }
}