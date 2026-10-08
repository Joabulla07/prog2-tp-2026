package org.curso.modelo;

/**
 * Clase Celular que implementa el patrón JAVABean.
 * Aplica encapsulamiento estricto con atributos privados y accesores validados.
 */
public class Celular {
    
    // Atributos privados (encapsulamiento estricto)
    private String marca;
    private String modelo;
    private String color;
    private double saldo;
    private EstadoLlamada estadoLlamada;
    
    // Variable estática para contar instancias de la clase
    private static int contadorInstancias = 0;
    private static final double COSTO_LLAMADA = 0.50;
    
    /**
     * Constructor público sin argumentos (requerido por JAVABean)
     */
    public Celular() {
        this.estadoLlamada = EstadoLlamada.INACTIVA;
        contadorInstancias++;
    }
    
    /**
     * Constructor parametrizado
     * @param marca Marca del celular
     * @param modelo Modelo del celular
     * @param color Color del celular
     * @param saldo Saldo inicial del celular
     */
    public Celular(String marca, String modelo, String color, double saldo) {
        this.estadoLlamada = EstadoLlamada.INACTIVA;
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setColor(color);
        this.setSaldo(saldo);
        contadorInstancias++;
    }
    
    // Getters y Setters con validaciones estrictas
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("La marca no puede ser nula o vacía");
        }
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede ser nulo o vacío");
        }
        this.modelo = modelo;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("El color no puede ser nulo o vacío");
        }
        this.color = color;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo");
        }
        this.saldo = saldo;
    }

    public EstadoLlamada getEstadoLlamada() {
        return estadoLlamada;
    }
    
    /**
     * Método estático para obtener el contador de instancias
     * @return Cantidad total de instancias creadas
     */
    public static int getContadorInstancias() {
        return contadorInstancias;
    }
    
    // Métodos de comportamiento
    
    /**
     * Simula una llamada telefónica
     * @param nombre Nombre del contacto a llamar
     */
    public void llamar(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: debe especificar un nombre válido para llamar");
            return;
        }
        if (saldo < COSTO_LLAMADA) {
            System.out.println("Error: saldo insuficiente para realizar la llamada");
            return;
        }
        if (estadoLlamada == EstadoLlamada.ACTIVA) {
            System.out.println("Error: ya hay una llamada en curso");
            return;
        }
        System.out.println("Llamando a " + nombre + "...");
        this.saldo -= COSTO_LLAMADA;
        this.estadoLlamada = EstadoLlamada.ACTIVA;
    }
    
    /**
     * Corta la llamada telefónica en curso
     */
    public void cortarLlamada() {
        if (estadoLlamada == EstadoLlamada.INACTIVA) {
            System.out.println("No hay llamada en curso");
            return;
        }
        this.estadoLlamada = EstadoLlamada.INACTIVA;
        System.out.println("Llamada finalizada");
    }
    
    /**
     * Informa las características del celular
     */
    public void informarCaracteristicas() {
        System.out.println("=== Características del Celular ===");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Color: " + color);
        System.out.println("Saldo: $" + String.format("%.2f", saldo));
        System.out.println("Estado de llamada: " + estadoLlamada);
        System.out.println("===================================");
    }

    protected double getCostoLlamadaProtegido() {
        return COSTO_LLAMADA;
    }

    protected boolean estaEnLlamadaProtegido() {
        return estadoLlamada == EstadoLlamada.ACTIVA;
    }

    String getResumenTecnico() {
        return "ResumenTecnico[marca=" + marca + ", modelo=" + modelo + ", estado=" + estadoLlamada + "]";
    }
    
    @Override
    public String toString() {
        return "Celular [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", saldo=$" + String.format("%.2f", saldo) + ", estadoLlamada=" + estadoLlamada + "]";
    }
}
