package Ejercicio2;

public class PedidoOnline implements Facturable {
    private String idPedido;
    private String cliente;
    private double montoTotal;
    private String direccionEnvio;

    public PedidoOnline(String idPedido, String cliente, double montoTotal, String direccionEnvio) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.montoTotal = montoTotal;
        this.direccionEnvio = direccionEnvio;
    }

    @Override
    public void emitirFactura() {
        System.out.println("=== FACTURA DE PEDIDO ONLINE ===");
        System.out.println("ID Pedido: " + idPedido);
        System.out.println("Cliente: " + cliente);
        System.out.println("Dirección de Envío: " + direccionEnvio);
        System.out.println("Monto Total: $" + montoTotal);
        System.out.println("IVA (21%): $" + (montoTotal * 0.21));
        System.out.println("Total con IVA: $" + (montoTotal * 1.21));
        System.out.println("================================");
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    @Override
    public String toString() {
        return "PedidoOnline{" +
                "idPedido='" + idPedido + '\'' +
                ", cliente='" + cliente + '\'' +
                ", montoTotal=" + montoTotal +
                ", direccionEnvio='" + direccionEnvio + '\'' +
                '}';
    }
}
