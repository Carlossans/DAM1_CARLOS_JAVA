package E861ExcepcionesEnReloj;

public class Reloj {
    private int h;
    private int m;

    public Reloj() {
        try {
            this.h = 8;
            this.m = 15;
        } catch (Exception e) {}
    }

    public Reloj(int h, int m) throws HoraNoValidaException, MinutoNoValidoException {
        if (h < 0 || h > 23) throw new HoraNoValidaException("Hora no válida: " + h);
        if (m < 0 || m > 59) throw new MinutoNoValidoException("Minuto no válido: " + m);
        this.h = h;
        this.m = m;
    }

    public Reloj(int totalMinutos) throws DesbordamientoRelojException {
        int limite = 24 * 60;
        if (totalMinutos >= limite) {
            throw new DesbordamientoRelojException(true, totalMinutos - (limite - 1));
        }
        if (totalMinutos < 0) {
            throw new DesbordamientoRelojException(false, Math.abs(totalMinutos));
        }
        this.h = totalMinutos / 60;
        this.m = totalMinutos % 60;
    }

    public int getH() { return h; }
    public void setH(int h) { this.h = h; }
    public int getM() { return m; }
    public void setM(int m) { this.m = m; }

    public String toString() {
        return String.format("%02d:%02d", h, m);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Reloj)) return false;
        Reloj otro = (Reloj) obj;
        return (this.h == otro.h && this.m == otro.m);
    }

    public Reloj clone() {
        try {
            return new Reloj(this.h, this.m);
        } catch (Exception e) {
            return null;
        }
    }

    private void normalizar() {
        while (m >= 60) { h++; m = m -60; }
        while (h >= 24) { h = h - 24; }
    }

    public void sumar(int minutos) throws OperacionNegativaRelojException, DesbordamientoRelojException {
        if (minutos < 0) throw new OperacionNegativaRelojException();
        int total = (h * 60) + m + minutos;
        if (total >= 1440) throw new DesbordamientoRelojException(true, total - 1439);
        this.m = this.m + minutos;
        normalizar();
    }

    public void restar(int minutos) throws OperacionNegativaRelojException, DesbordamientoRelojException {
        if (minutos < 0) throw new OperacionNegativaRelojException();
        int total = (h * 60) + m - minutos;
        if (total < 0) throw new DesbordamientoRelojException(false, Math.abs(total));
        this.m = this.m - minutos;
        normalizar();
    }
}