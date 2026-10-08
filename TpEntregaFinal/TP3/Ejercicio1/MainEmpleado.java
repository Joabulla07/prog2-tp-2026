package Ejercicio1;

public class MainEmpleado {
    public static void main(String[] args) {
        // Crear arreglo homogéneo de tipo Empleado[]
        Empleado[] empleados = new Empleado[4];

        // Instanciar objetos polimórficos
        empleados[0] = new EmpleadoContratado("Juan Pérez", 101, 1000.0, 50.0, 40);
        empleados[1] = new EmpleadoEfectivo("María García", 102, 2000.0, 500.0, 200.0);
        empleados[2] = new EmpleadoContratado("Carlos López", 103, 1200.0, 45.0, 35);
        empleados[3] = new EmpleadoEfectivo("Ana Rodríguez", 104, 2500.0, 800.0, 300.0);

        // Recorrer el arreglo y demostrar polimorfismo dinámico
        System.out.println("=== Demostración de Polimorfismo Dinámico ===\n");
        
        double totalSalarios = 0;
        
        for (Empleado emp : empleados) {
            System.out.println(emp);
            System.out.println("Salario calculado: $" + emp.calcularSalario());
            System.out.println("----------------------------------------");
            totalSalarios += emp.calcularSalario();
        }

        System.out.println("\nTotal de salarios: $" + totalSalarios);
        
        // Demostración de que el tipo en tiempo de ejecución determina el método
        System.out.println("\n=== Verificación de Tipos en Tiempo de Ejecución ===");
        for (Empleado emp : empleados) {
            System.out.println(emp.getNombre() + " es instancia de: " + 
                emp.getClass().getSimpleName());
        }
    }
}
