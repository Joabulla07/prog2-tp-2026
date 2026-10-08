package Ejercicio2;

public class MainFacturable {
    
    // Módulo procesador que acepta parámetros de tipo Facturable
    // Demostración de desacoplamiento: el procesador no conoce las clases concretas
    public static void procesarFacturacion(Facturable facturable) {
        System.out.println("\nProcesando facturación...");
        facturable.emitirFactura();
        System.out.println("Facturación completada exitosamente.\n");
    }
    
    // Método que procesa múltiples objetos Facturable
    public static void procesarLoteFacturacion(Facturable[] facturables) {
        System.out.println("=== PROCESANDO LOTE DE FACTURACIÓN ===");
        for (Facturable facturable : facturables) {
            procesarFacturacion(facturable);
        }
        System.out.println("=== FIN DEL PROCESAMIENTO DE LOTE ===\n");
    }

    public static void main(String[] args) {
        // Crear instancias de clases sin relación jerárquica
        PedidoOnline pedido1 = new PedidoOnline("PED-001", "Juan Pérez", 1500.0, "Av. Siempre Viva 123");
        PedidoOnline pedido2 = new PedidoOnline("PED-002", "María García", 2300.0, "Calle Falsa 456");
        
        ContratoServicio contrato1 = new ContratoServicio("CTR-001", "Tech Solutions S.A.", "Mantenimiento IT", 5000.0, 12);
        ContratoServicio contrato2 = new ContratoServicio("CTR-002", "Global Corp", "Consultoría", 8000.0, 6);

        // Demostración de desacoplamiento: procesar individualmente
        System.out.println("=== DEMOSTRACIÓN DE DESACOPLAMIENTO ===");
        System.out.println("El procesador solo conoce la interfaz Facturable, no las clases concretas.\n");
        
        procesarFacturacion(pedido1);
        procesarFacturacion(contrato1);
        
        // Demostración con arreglo heterogéneo de tipo Facturable[]
        Facturable[] facturables = new Facturable[4];
        facturables[0] = pedido1;
        facturables[1] = pedido2;
        facturables[2] = contrato1;
        facturables[3] = contrato2;
        
        procesarLoteFacturacion(facturables);
        
        // Verificación de desacoplamiento
        System.out.println("=== VERIFICACIÓN DE DESACOPLAMIENTO ===");
        System.out.println("Las clases PedidoOnline y ContratoServicio no tienen relación jerárquica.");
        System.out.println("Ambas implementan la interfaz Facturable, permitiendo el polimorfismo.");
        System.out.println("El procesador puede trabajar con cualquier clase que implemente Facturable.");
    }
}
