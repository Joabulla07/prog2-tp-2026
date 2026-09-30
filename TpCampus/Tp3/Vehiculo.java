package TpCampus.Tp3;

public class Vehiculo {
    protected String patente;
    protected String marca;
    protected double costoBaseKm;

    public Vehiculo(String patente, String marca, double costoBaseKm){
        this.patente = patente;
        this.marca = marca;
        this.costoBaseKm = costoBaseKm;
    }

    public double calcularCostoViaje(double distanciaKm){
        return distanciaKm * this.costoBaseKm;
    }

    public double calcularCostoViaje(double distanciaKm, double peajes){
        return this.calcularCostoViaje(distanciaKm) + peajes;
    }

    public void mostrarFicha(){
        System.out.println("Patente: " + this.patente);
        System.out.println("Marca: " + this.marca);
        System.out.println("Costo Base por Km: " + this.costoBaseKm);
    }

}
