package Ejercicio2;

public class ContratoServicio implements Facturable {
    private String numeroContrato;
    private String empresaCliente;
    private String tipoServicio;
    private double tarifaMensual;
    private int duracionMeses;

    public ContratoServicio(String numeroContrato, String empresaCliente, String tipoServicio, 
                           double tarifaMensual, int duracionMeses) {
        this.numeroContrato = numeroContrato;
        this.empresaCliente = empresaCliente;
        this.tipoServicio = tipoServicio;
        this.tarifaMensual = tarifaMensual;
        this.duracionMeses = duracionMeses;
    }

    @Override
    public void emitirFactura() {
        double total = tarifaMensual * duracionMeses;
        System.out.println("=== FACTURA DE CONTRATO DE SERVICIO ===");
        System.out.println("Número de Contrato: " + numeroContrato);
        System.out.println("Empresa Cliente: " + empresaCliente);
        System.out.println("Tipo de Servicio: " + tipoServicio);
        System.out.println("Tarifa Mensual: $" + tarifaMensual);
        System.out.println("Duración: " + duracionMeses + " meses");
        System.out.println("Total del Contrato: $" + total);
        System.out.println("IVA (21%): $" + (total * 0.21));
        System.out.println("Total con IVA: $" + (total * 1.21));
        System.out.println("========================================");
    }

    public double getTarifaMensual() {
        return tarifaMensual;
    }

    @Override
    public String toString() {
        return "ContratoServicio{" +
                "numeroContrato='" + numeroContrato + '\'' +
                ", empresaCliente='" + empresaCliente + '\'' +
                ", tipoServicio='" + tipoServicio + '\'' +
                ", tarifaMensual=" + tarifaMensual +
                ", duracionMeses=" + duracionMeses +
                '}';
    }
}
