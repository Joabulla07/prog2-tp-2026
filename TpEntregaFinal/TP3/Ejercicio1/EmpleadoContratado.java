package Ejercicio1;

public class EmpleadoContratado extends Empleado {
    private double tarifaPorHora;
    private int horasTrabajadas;

    public EmpleadoContratado(String nombre, int id, double salarioBase, double tarifaPorHora, int horasTrabajadas) {
        super(nombre, id, salarioBase);
        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + (tarifaPorHora * horasTrabajadas);
    }

    @Override
    public String toString() {
        return "EmpleadoContratado{" +
                "nombre='" + getNombre() + '\'' +
                ", id=" + getId() +
                ", salarioBase=" + getSalarioBase() +
                ", tarifaPorHora=" + tarifaPorHora +
                ", horasTrabajadas=" + horasTrabajadas +
                ", salarioCalculado=" + calcularSalario() +
                '}';
    }
}
