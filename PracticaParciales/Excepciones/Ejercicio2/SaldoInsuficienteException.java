package PracticaParciales.Excepciones.Ejercicio2;

public class SaldoInsuficienteException extends Exception {
    private final double saldoDisponible;
    private final double montoSolicitado;

    public SaldoInsuficienteException(String mensaje, double saldoDisponible, double montoSolicitado) {
        super(mensaje);
        this.saldoDisponible = saldoDisponible;
        this.montoSolicitado = montoSolicitado;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public double getMontoSolicitado() {
        return montoSolicitado;
    }
}
