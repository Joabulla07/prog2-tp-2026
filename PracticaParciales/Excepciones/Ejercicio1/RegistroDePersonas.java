package PracticaParciales.Excepciones.Ejercicio1;

 class RegistroDePersonas {
    private static final int EDAD_MINIMA = 0;
    private static final int EDAD_MAXIMA = 120;

    public void registrar(String nombre, int edad) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (edad < EDAD_MINIMA || edad > EDAD_MAXIMA) {
            throw new EdadInvalidaException(edad);
        }
        System.out.println("  ✓ Registrado: " + nombre + ", " + edad + " años");
    }

    public void registrarDesdeTexto(String nombre, String edadTexto) {
        int edad;
        try {
            edad = Integer.parseInt(edadTexto.trim());
        } catch (NumberFormatException e) {
            // Traducimos al lenguaje de NUESTRO dominio, sin perder la causa
            throw new EdadInvalidaException(
                "'" + edadTexto + "' no es un número válido para una edad", e);
        }
        registrar(nombre, edad);   // la validación de rango vive en un solo lugar
    }
}