package PracticaParciales.Excepciones.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        RegistroDePersonas registro = new RegistroDePersonas();

        String[][] intentos = {
            {"Laura Giménez", "28"},      // válido
            {"Carlos Ruiz",   "150"},     // fuera de rango
            {"Ana Torres",    "treinta"}  // no es un número
        };

        for (String[] intento : intentos) {
            System.out.println("Intentando registrar a " + intento[0] + "...");
            try {
                registro.registrarDesdeTexto(intento[0], intento[1]);
            } catch (EdadInvalidaException e) {
                System.out.println("  ✗ " + e.getMessage());
                if (e.getCause() != null) {
                    // La causa original sigue disponible para el log técnico
                    System.out.println("    causa técnica: " + e.getCause());
                }
            } catch (IllegalArgumentException e) {
                System.out.println("  ✗ Dato inválido: " + e.getMessage());
            } finally {
                System.out.println("  — intento finalizado —\n");
            }
        }
    }
}
