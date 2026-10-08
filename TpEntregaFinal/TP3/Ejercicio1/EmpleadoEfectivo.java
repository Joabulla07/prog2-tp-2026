package Ejercicio1;

public class EmpleadoEfectivo extends Empleado {
    private double bono;
    private double deducciones;

    public EmpleadoEfectivo(String nombre, int id, double salarioBase, double bono, double deducciones) {
        super(nombre, id, salarioBase);
        this.bono = bono;
        this.deducciones = deducciones;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + bono - deducciones;
    }

    @Override
    public String toString() {
        return "EmpleadoEfectivo{" +
                "nombre='" + getNombre() + '\'' +
                ", id=" + getId() +
                ", salarioBase=" + getSalarioBase() +
                ", bono=" + bono +
                ", deducciones=" + deducciones +
                ", salarioCalculado=" + calcularSalario() +
                '}';
    }
}
