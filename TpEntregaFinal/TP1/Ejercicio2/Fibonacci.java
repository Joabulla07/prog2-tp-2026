package TpEntregaFinal.TP1.Ejercicio2;

class Fibonacci {

    private String nombre;
    private int tamano;

    public Fibonacci(String nombre, int tamano){
        this.nombre = nombre;
        this.tamano = tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public String mostrarSerie() {
        StringBuilder serie = new StringBuilder();

        if (tamano <= 0) {
            return this.nombre + ":  ";
        }

        int a = 0, b = 1;

        for (int i = 0; i < tamano; i++) {
            if (i > 0) {
                serie.append(" ");
            }
            serie.append(a);
            int siguiente = a + b;
            a = b;
            b = siguiente;
        }

        return this.nombre +": "+serie;
    }

}
