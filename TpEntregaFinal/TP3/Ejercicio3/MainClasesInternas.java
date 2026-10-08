package Ejercicio3;

public class MainClasesInternas {

    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 3: CLASES INTERNAS Y ANÓNIMAS ===\n");

        // 1. Demostración de Clase Interna (Inner Class)
        System.out.println("--- 1. CLASE INTERNA (INNER CLASS) ---");
        System.out.println("Instanciación: Outer.Inner inner = outer.new Inner();\n");

        Outer outer = new Outer();
        
        // Sintaxis para instanciar clase interna desde fuera
        Outer.Inner inner = outer.new Inner();
        
        inner.accederDatosOuter();
        inner.mostrarDatoInterno();
        
        System.out.println("\n--- Creando Inner desde método de Outer ---");
        outer.crearYUsarInner();

        System.out.println("\n--- Instanciación desde método estático ---");
        Outer.demostrarInstanciacion();

        // 2. Demostración de Clase Anónima implementando Runnable
        System.out.println("\n\n--- 2. CLASE ANÓNIMA (ANONYMOUS CLASS) ---");
        System.out.println("Implementando interfaz Runnable directamente en el argumento\n");

        // Clase anónima implementando Runnable
        Runnable miRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Ejecutando tarea en hilo separado...");
                System.out.println("Esta es una clase anónima que implementa Runnable");
                System.out.println("Tarea completada exitosamente");
            }
        };

        // Ejecutar el Runnable
        System.out.println("Iniciando ejecución de clase anónima:");
        miRunnable.run();

        // 3. Clase anónima directamente en el argumento de un método
        System.out.println("\n--- 3. CLASE ANÓNIMA COMO ARGUMENTO DE MÉTODO ---");
        
        ejecutarTarea(new Runnable() {
            @Override
            public void run() {
                System.out.println("Tarea ejecutada desde clase anónima pasada como argumento");
                System.out.println("No necesitamos una variable para almacenar la instancia");
            }
        });

        // 4. Clase anónima para responder a un evento simulado
        System.out.println("\n--- 4. CLASE ANÓNIMA PARA RESPONDER A EVENTO ---");
        
        Boton boton = new Boton();
        
        // Asignar un ActionListener (clase anónima) al botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void onActionPerformed(String evento) {
                System.out.println("Evento recibido: " + evento);
                System.out.println("Respondiendo al clic del botón con clase anónima");
            }
        });
        
        // Simular clic
        boton.click();

        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }

    // Método que acepta Runnable como parámetro
    public static void ejecutarTarea(Runnable tarea) {
        System.out.println("Preparando ejecución de tarea...");
        tarea.run();
        System.out.println("Tarea finalizada\n");
    }

    // Interfaz simple para simular eventos
    interface ActionListener {
        void onActionPerformed(String evento);
    }

    // Clase simple que simula un botón
    static class Boton {
        private ActionListener listener;

        public void addActionListener(ActionListener listener) {
            this.listener = listener;
        }

        public void click() {
            if (listener != null) {
                listener.onActionPerformed("CLICK_EVENT");
            }
        }
    }
}
