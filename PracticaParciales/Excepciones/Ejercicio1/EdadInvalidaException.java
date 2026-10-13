package PracticaParciales.Excepciones.Ejercicio1;

public class EdadInvalidaException extends RuntimeException {
    private final int edadRechazada;

    public EdadInvalidaException(int edadRechazada) {
        super("Edad inválida: " + edadRechazada + ". Debe estar entre 0 y 120.");
        this.edadRechazada = edadRechazada;
    }

    // Constructor con causa: para envolver otra excepción sin perderla
    public EdadInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
        this.edadRechazada = -1;
    }

    public int getEdadRechazada() { return edadRechazada; }
}
