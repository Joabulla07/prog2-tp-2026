package TpCampus.Tp2;

// Clase final: no está pensada para extenderse porque representa una entidad de dominio
// con comportamiento específico (préstamos, devoluciones) y validaciones de negocio.
public final class Libro {

    private final String titulo;
    private final String autor;
    private final String isbn;
    private int copiasDisponibles;
    private double precioReposicion;
    private int prestamosHistoricos;

    public Libro(String titulo, String autor, String isbn, int copiasDisponibles, double precioReposicion) {
        if (titulo == null || titulo.isEmpty()) {
            System.out.println("Se rechazó titulo: es null. Se usó 'Sin título'.");
            this.titulo = "Sin título";
        } else {
            this.titulo = titulo;
        }

        if (autor == null || autor.isEmpty()) {
            System.out.println("Se rechazó autor: es null. Se usó 'Autor desconocido'.");
            this.autor = "Autor desconocido";
        } else {
            this.autor = autor;
        }

        if (isbn == null || isbn.isEmpty()) {
            System.out.println("Se rechazó isbn: es null. Se usó 'ISBN pendiente'.");
            this.isbn = "ISBN pendiente";
        } else {
            this.isbn = isbn;
        }

        if (copiasDisponibles < 0) {
            System.out.println("Se rechazó copiasDisponibles: no puede ser negativa. Se usó '0'.");
            this.copiasDisponibles = 0;
        } else {
            this.copiasDisponibles = copiasDisponibles;
        }

        if (!validarPrecioReposicion(precioReposicion)) {
            System.out.println("Se rechazó precioReposicion: debe ser mayor a 0. Se usó '$15000.0'.");
            this.precioReposicion = 15000.0;
        } else {
            this.precioReposicion = precioReposicion;
        }
    }

    private boolean validarPrecioReposicion(double precio) {
        return precio > 0;
    }

    public Libro(String titulo, String autor, String isbn) {
        this(titulo, autor, isbn, 1, 15000.0);
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public int getCopiasDisponibles() {
        return this.copiasDisponibles;
    }

    public double getPrecioReposicion() {
        return this.precioReposicion;
    }

    public int getPrestamosHistoricos() {
        return this.prestamosHistoricos;
    }

    public boolean setPrecioReposicion(double precio) {
        if (validarPrecioReposicion(precio)) {
            this.precioReposicion = precio;
            return true;
        }
        System.out.println("Error: el precio de reposición debe ser mayor a 0.");
        return false;
    }

    public boolean prestar() {
        this.prestamosHistoricos++;
        if (this.copiasDisponibles > 0) {
            this.copiasDisponibles--;
            System.out.println("Préstamo registrado. Copias disponibles: " + this.copiasDisponibles);
            return true;
        }
        System.out.println("No hay copias disponibles para prestar.");
        return false;
    }

    public void devolver() {
        this.copiasDisponibles++;
        System.out.println("Devolución registrada. Copias disponibles: " + this.copiasDisponibles);
    }


    public void mostrarFicha() {
        System.out.println("=== Ficha del libro ===");
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Copias disponibles: " + this.copiasDisponibles);
        System.out.println("Precio de reposición: $" + this.precioReposicion);
    }
}
