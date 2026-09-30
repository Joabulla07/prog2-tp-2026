package TpCampus.Tp3;

public class Furgoneta extends Vehiculo{
    private boolean tieneRefrigeracion;

    public Furgoneta(String patente, String marca, double costoBaseKm, boolean tieneRefrigeracion){
        super(patente, marca, costoBaseKm);
        this.tieneRefrigeracion = tieneRefrigeracion;
    }

    @Override
    public double calcularCostoViaje(double distanciaKm){
        if(this.tieneRefrigeracion){
            return (distanciaKm * this.costoBaseKm) + 5000;
        } else {
            return distanciaKm * this.costoBaseKm;
        }
    }

    public boolean isTieneRefrigeracion() {
        return tieneRefrigeracion;
    }

    public void setTieneRefrigeracion(boolean tieneRefrigeracion) {
        this.tieneRefrigeracion = tieneRefrigeracion;
    }
}
