package org.curso.test;

import org.curso.externo.CelularPremium;
import org.curso.modelo.Celular;

/**
 * Clase de prueba para demostrar:
 * - Modificadores de acceso (public, private, protected, default)
 * - Miembros estáticos (static)
 * - Igualación de referencias en memoria
 * - Operador instanceof
 */
public class TestCelular {
    
    public static void main(String[] args) {
        System.out.println("=== TRABAJO PRÁCTICO N° 2: FUNDAMENTOS DE POO ===\n");
        
        // 1. Demostración de constructores y contador estático
        System.out.println("--- 1. CONSTRUCTORES Y MIEMBROS ESTÁTICOS ---");
        System.out.println("Contador inicial: " + Celular.getContadorInstancias());
        
        Celular celular1 = new Celular();
        System.out.println("Después de crear celular1: " + Celular.getContadorInstancias());
        
        Celular celular2 = new Celular("Samsung", "Galaxy S21", "Negro", 100.0);
        System.out.println("Después de crear celular2: " + Celular.getContadorInstancias());
        
        Celular celular3 = new Celular("Apple", "iPhone 13", "Azul", 150.0);
        System.out.println("Después de crear celular3: " + Celular.getContadorInstancias());
        System.out.println();
        
        // 2. Demostración de getters/setters con validaciones
        System.out.println("--- 2. GETTERS/SETTERS CON VALIDACIONES ---");
        celular1.setMarca("Xiaomi");
        celular1.setModelo("Redmi Note 10");
        celular1.setColor("Blanco");
        celular1.setSaldo(50.0);
        
        celular1.informarCaracteristicas();
        System.out.println();
        
        // 3. Demostración de validaciones (esto lanzará excepción si se descomenta)
        System.out.println("--- 3. VALIDACIONES EN SETTERS ---");
        try {
            celular1.setSaldo(-10.0);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validación correcta: " + e.getMessage());
        }
        
        try {
            celular1.setMarca("");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validación correcta: " + e.getMessage());
        }
        System.out.println();
        
        // 4. Demostración de métodos de comportamiento
        System.out.println("--- 4. MÉTODOS DE COMPORTAMIENTO ---");
        System.out.println("Estado inicial de celular2: " + celular2.getEstadoLlamada());
        celular2.llamar("Juan");
        System.out.println("Estado durante llamada de celular2: " + celular2.getEstadoLlamada());
        celular2.cortarLlamada();
        System.out.println("Estado final de celular2: " + celular2.getEstadoLlamada());
        System.out.println("Saldo después de la llamada: $" + String.format("%.2f", celular2.getSaldo()));
        
        celular3.llamar("María");
        celular3.cortarLlamada();
        System.out.println("Saldo después de la llamada: $" + String.format("%.2f", celular3.getSaldo()));
        System.out.println();
        
        // 5. Demostración de igualación de referencias
        System.out.println("--- 5. IGUALACIÓN DE REFERENCIAS EN HEAP ---");
        Celular ref1 = celular1;
        Celular ref2 = celular1;
        
        System.out.println("ref1 == celular1: " + (ref1 == celular1));
        System.out.println("ref2 == celular1: " + (ref2 == celular1));
        System.out.println("ref1 == ref2: " + (ref1 == ref2));
        System.out.println("celular1 == celular2: " + (celular1 == celular2));
        
        System.out.println("\nModificando saldo a través de ref1:");
        ref1.setSaldo(200.0);
        System.out.println("celular1.getSaldo(): $" + String.format("%.2f", celular1.getSaldo()));
        System.out.println("ref2.getSaldo(): $" + String.format("%.2f", ref2.getSaldo()));
        System.out.println("Todas las referencias apuntan al mismo objeto en el Heap");
        System.out.println();
        
        // 6. Demostración del operador instanceof y casting seguro
        System.out.println("--- 6. OPERADOR INSTANCEOF Y CASTING ---");
        System.out.println("celular1 instanceof Celular: " + (celular1 instanceof Celular));
        System.out.println("ref1 instanceof Celular: " + (ref1 instanceof Celular));
        System.out.println("celular1 instanceof Object: " + (celular1 instanceof Object));

        Object referenciaGenerica = celular2;
        if (referenciaGenerica instanceof Celular) {
            Celular celularCasteado = (Celular) referenciaGenerica;
            System.out.println("Casting realizado con éxito. Marca obtenida: " + celularCasteado.getMarca());
        }
        System.out.println();
        
        // 7. Demostración de modificadores de acceso
        System.out.println("--- 7. MODIFICADORES DE ACCESO ---");
        System.out.println("Atributos privados: NO accesibles directamente desde otro paquete");
        System.out.println("✓ getMarca() es PUBLIC: accesible desde cualquier paquete");
        System.out.println("✓ setMarca() es PUBLIC: accesible desde cualquier paquete");
        System.out.println("✗ marca es PRIVATE: no accesible desde fuera de la clase");
        System.out.println("✗ Si intentamos 'celular1.marca', el compilador dará error");

        CelularPremium premium = new CelularPremium("Google", "Pixel 8", "Gris", 80.0);
        premium.mostrarAccesoProtegido();

        // DESCOMENTAR para comprobar errores de compilación esperados:
        // System.out.println(celular1.marca);
        // ERROR: marca has private access in Celular
        //
        // System.out.println(celular1.getCostoLlamadaProtegido());
        // ERROR: getCostoLlamadaProtegido() has protected access in Celular
        //
        // System.out.println(celular1.getResumenTecnico());
        // ERROR: getResumenTecnico() is not public in Celular; cannot be accessed from outside package
        System.out.println();
        
        // 8. Resumen final
        System.out.println("--- 8. RESUMEN FINAL ---");
        System.out.println("Total de instancias creadas: " + Celular.getContadorInstancias());
        System.out.println("La variable estática 'contadorInstancias' es compartida por todas las instancias");
        System.out.println("Cada objeto tiene sus propios atributos de instancia (marca, modelo, color, saldo)");
        
        System.out.println("\n=== FIN DEL TEST ===");
    }
}
