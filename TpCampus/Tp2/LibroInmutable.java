package TpCampus.Tp2;

// Record inmutable: portador de datos puro sin comportamiento de negocio.
// Todos sus campos son final y se generan automáticamente getters, equals, hashCode y toString.
public record LibroInmutable(String titulo, String autor, String isbn) {
    public LibroInmutable {
        // Validación en el constructor compacto del record
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El título no puede ser null ni estar vacío");
        }
        if (autor == null || autor.isEmpty()) {
            throw new IllegalArgumentException("El autor no puede ser null ni estar vacío");
        }
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("El ISBN no puede ser null ni estar vacío");
        }
    }
}
