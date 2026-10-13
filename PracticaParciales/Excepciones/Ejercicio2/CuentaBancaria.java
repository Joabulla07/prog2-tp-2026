package PracticaParciales.Excepciones.Ejercicio2;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        if (numeroCuenta == null || numeroCuenta.isBlank()) {
            throw new IllegalArgumentException("El número de cuenta es obligatorio");
        }
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("El titular es obligatorio");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new MontoInvalidoException("Monto a depositar inválido: " + monto);
        }
        saldo += monto;
    }

    public void extraer(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) {
            throw new MontoInvalidoException("Monto a extraer inválido: " + monto);
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Fondos insuficientes", this.saldo, monto);
        }
        saldo -= monto;
    }

    public void transferir(CuentaBancaria destino, double monto) throws SaldoInsuficienteException {
        if (destino == null) {
            throw new IllegalArgumentException("La cuenta de destino no puede ser null");
        }
        extraer(monto);
        destino.depositar(monto);
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
