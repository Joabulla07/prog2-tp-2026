package PracticaParciales.Excepciones.Ejercicio2;

public class MainBanco {
    public static void main(String[] args) {
        System.out.println("=== Auditoría de Transacciones Bancarias ===");
        
        CuentaBancaria cuenta1 = new CuentaBancaria("CA-001", "Laura Torres", 0);
        CuentaBancaria cuenta2 = new CuentaBancaria("CA-002", "Carlos Ruiz", 50000);
        
        int registroId = 8841;
        
        try {
            // Caso 1: Depósito válido
            cuenta1.depositar(100000);
            System.out.println("[OK] Depósito exitoso de $100000.0 en cuenta CA-001 (Titular: Laura Torres)");
            System.out.println("[OK] Saldo actual: $" + cuenta1.getSaldo());
            
            // Caso 2: Extracción válida
            cuenta1.extraer(20000);
            System.out.println("[OK] Extracción exitosa de $20000.0");
            System.out.println("[OK] Saldo actual: $" + cuenta1.getSaldo());
            
            // Caso 3: Extracción que excede el saldo
            try {
                cuenta1.extraer(150000);
            } catch (SaldoInsuficienteException e) {
                System.out.println("[ALERTA] Intento de extracción de $" + e.getMontoSolicitado() + " rechazado:");
                System.out.println("         Saldo disponible ($" + e.getSaldoDisponible() + ") insuficiente para el monto solicitado ($" + e.getMontoSolicitado() + ").");
            }
            
            // Caso 4: Operación con monto negativo
            try {
                cuenta1.depositar(-500);
            } catch (MontoInvalidoException e) {
                System.out.println("[ERROR] Intento de depósito con monto negativo rechazado: " + e.getMessage());
            }
            
            // Caso 5: Transferencia válida
            cuenta1.transferir(cuenta2, 10000);
            System.out.println("[OK] Transferencia exitosa de $10000.0 de CA-001 a CA-002");
            System.out.println("[OK] Saldo CA-001: $" + cuenta1.getSaldo());
            System.out.println("[OK] Saldo CA-002: $" + cuenta2.getSaldo());
            
            // Caso 6: Transferencia con saldo insuficiente (verificar consistencia)
            try {
                cuenta1.transferir(cuenta2, 200000);
            } catch (SaldoInsuficienteException e) {
                System.out.println("[ALERTA] Transferencia rechazada por saldo insuficiente");
                System.out.println("         Saldo disponible ($" + e.getSaldoDisponible() + ") insuficiente para el monto solicitado ($" + e.getMontoSolicitado() + ").");
                System.out.println("[OK] Saldo CA-002 no modificado: $" + cuenta2.getSaldo() + " (consistencia mantenida)");
            }
            
        } catch (SaldoInsuficienteException e) {
            System.out.println("[ERROR] Saldo insuficiente: " + e.getMessage());
            System.out.println("         Saldo disponible: $" + e.getSaldoDisponible());
            System.out.println("         Monto solicitado: $" + e.getMontoSolicitado());
        } catch (MontoInvalidoException e) {
            System.out.println("[ERROR] Monto inválido: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] Argumento inválido: " + e.getMessage());
        } finally {
            System.out.println("--------------------------------------------------");
            System.out.println("[AUDITORÍA - FINALLY]: Sesión transaccional cerrada con registro ID #" + registroId + ".");
        }
    }
}
