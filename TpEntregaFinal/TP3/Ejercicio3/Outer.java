package Ejercicio3;

public class Outer {
    private String datoPrivado = "Dato privado de la clase Outer";
    private int numeroSecreto = 42;

    // Clase interna (Inner Class)
    public class Inner {
        private String datoInterno = "Dato de la clase Inner";

        public void accederDatosOuter() {
            // La clase interna puede acceder a miembros privados de la clase contenedora
            System.out.println("Acceso desde Inner a datoPrivado: " + datoPrivado);
            System.out.println("Acceso desde Inner a numeroSecreto: " + numeroSecreto);
        }

        public void mostrarDatoInterno() {
            System.out.println("Dato interno: " + datoInterno);
        }

        public String getDatoInterno() {
            return datoInterno;
        }
    }

    // Método de Outer que utiliza la clase interna
    public void crearYUsarInner() {
        Inner inner = new Inner();
        inner.accederDatosOuter();
        inner.mostrarDatoInterno();
    }

    // Método que devuelve una instancia de Inner
    public Inner getInnerInstance() {
        return new Inner();
    }

    // Método estático para demostrar la instanciación desde fuera
    public static void demostrarInstanciacion() {
        Outer outer = new Outer();
        // Sintaxis: Outer.Inner inner = outer.new Inner();
        Outer.Inner inner = outer.new Inner();
        inner.accederDatosOuter();
    }
}
