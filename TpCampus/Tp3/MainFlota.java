package TpCampus.Tp3;

public class MainFlota {
    public static void main(String[] args) {
        Vehiculo[] flota = new Vehiculo[3];

        flota[0] = new Camion("AA123BB", "Scania", 500.0, 18.0);
        flota[1] = new Furgoneta("AF456CD", "Mercedes-Benz", 450.0, true);
        flota[2] = new motoEnvios("A099XYZ", "Honda", 180.0);

        double costoTotal = 0.0;

        System.out.println("=== Reporte de Operaciones de Flota ===");

        for (Vehiculo v : flota) {
            v.mostrarFicha();
            double costoViaje = v.calcularCostoViaje(150.0);
            System.out.println("Costo de viaje (150.0 km): $" + costoViaje);
            System.out.println("--------------------------------------------------");
            costoTotal += costoViaje;
        }

        System.out.println("Costo total operativo de la flota: $" + costoTotal);
    }
}
