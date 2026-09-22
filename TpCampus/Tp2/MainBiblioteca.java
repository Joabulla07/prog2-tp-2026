package TpCampus.Tp2;

public class MainBiblioteca {
    public static void main(String[] args) {

        System.out.println("=== Creación de libros ===");
        // new Libro(); // no compila: al declarar constructores propios, el constructor sin parámetros que regalaba el compilador ya no existe

        Libro libro1 = new Libro("El principito", "Antoine de Saint-Exupéry", "978-3-16-148410-0", 3, 20000.0);
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", "978-0-14-018732-4");
        
        System.out.println("\n--- Casos inválidos ---");
        Libro libro3 = new Libro("", "J.K. Rowling", "978-0-7475-3269-9", 5, 25000.0);
        Libro libro3Null = new Libro(null, "Autor Test", "978-0-7475-3269-9", 5, 25000.0);
        Libro libro4 = new Libro("Harry Potter", "J.K. Rowling", "978-0-7475-3269-9", -5, 25000.0);
        Libro libro5 = new Libro("Don Quijote", "Miguel de Cervantes", "978-0-06-093434-7", 2, 0);

        System.out.println("\n=== Demostración de rechazo: título vacío ===");
        System.out.println("Título asignado: " + libro3.getTitulo());

        System.out.println("\n=== Demostración de rechazo: título null ===");
        System.out.println("Título asignado: " + libro3Null.getTitulo());

        System.out.println("\n=== Demostración de rechazo: copias negativas ===");
        System.out.println("Copias asignadas: " + libro4.getCopiasDisponibles());

        System.out.println("\n=== Demostración de rechazo: precio en cero ===");
        System.out.println("Precio asignado: $" + libro5.getPrecioReposicion());

        System.out.println("\n=== Demostración de rechazo: precio inválido ===");
        double precioOriginal = libro1.getPrecioReposicion();
        System.out.println("Precio original: $" + precioOriginal);
        boolean resultado = libro1.setPrecioReposicion(-100);
        System.out.println("Resultado de setPrecioReposicion(-100): " + resultado);
        System.out.println("Precio después del intento: $" + libro1.getPrecioReposicion());

        System.out.println("\n=== Agotar copias de libro1 ===");
        System.out.println("Copias disponibles iniciales: " + libro1.getCopiasDisponibles());
        
        boolean prestamo1 = libro1.prestar();
        System.out.println("Préstamo 1: " + prestamo1);
        
        boolean prestamo2 = libro1.prestar();
        System.out.println("Préstamo 2: " + prestamo2);
        
        boolean prestamo3 = libro1.prestar();
        System.out.println("Préstamo 3: " + prestamo3);
        
        boolean prestamo4 = libro1.prestar();
        System.out.println("Préstamo 4 (debería fallar): " + prestamo4);
        System.out.println("Copias disponibles después de agotar: " + libro1.getCopiasDisponibles());

        System.out.println("\n=== Devolver libro ===");
        libro1.devolver();

        System.out.println("\n=== Fichas de los libros ===\n");

        Libro[] listaLibros = {libro1, libro2, libro3, libro3Null, libro4, libro5};

        for(Libro items: listaLibros){
            items.mostrarFicha();
            System.out.println();
        }

    }
}
