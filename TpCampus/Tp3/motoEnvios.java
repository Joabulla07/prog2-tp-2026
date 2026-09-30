package TpCampus.Tp3;

public class motoEnvios extends Vehiculo{

    public motoEnvios(String patente, String marca, double costoBaseKm){
        super(patente, marca, costoBaseKm);
    }

    @Override
    public double calcularCostoViaje(double distanciaKm){
        return (distanciaKm * this.costoBaseKm) * 0.85;
    }
}
