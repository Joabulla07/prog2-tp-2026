package TpCampus.Tp1;

public class Producto {

    public String nombre;
    public String codigo;
    public double precio;
    public int stock;

    public Producto(String nombre, String codigo, double precio, int stock) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
    }

    public void venderUnidades(int cantidad) {
        if(cantidad > 0){
            if(cantidad < this.stock){
                this.stock-=cantidad;
                System.out.println("Venta realizada: "+cantidad+" "+this.nombre+". Stock restante: "+this.stock);
            } else {
                System.out.println("Error: stock insuficiente para vender "+cantidad+" unidades de "+this.nombre);
            }
        } else {
            System.out.println("Error: El valor ingresado es negativo");
        }
    }

    public void reponerStock(int cantidad) {
        if(cantidad > 0){
            this.stock+=cantidad;
            System.out.println("Reposición registrada: +"+cantidad+" unidades de "+this.nombre+". Stock actual: "+this.stock);
        } else {
            System.out.println("Error: el valor ingresado es negativo");
        }
    }

    public void actualizarPrecio(double precio) {
        double actual = this.precio;
        this.precio = precio;
        System.out.println("Precio actualizado de "+this.nombre+": $"+actual+" -> $"+this.precio);
    }

    public void mostrarFicha() {
        System.out.println("=== Ficha de producto ===");
        System.out.println("Código:  " + this.codigo);
        System.out.println("Nombre:  " + this.nombre);
        System.out.println("Precio:  $" + this.precio);
        System.out.println("Stock:   " + this.stock);
    }

    public void aplicarDescuento(double porcentaje){
        if(porcentaje >=0 && porcentaje <= 100){
            double descuento = this.precio - ((porcentaje * this.precio) / 100);
            System.out.println("El precio de "+this.nombre+" con descuento del "+porcentaje+"% es de: $"+descuento);
        } else {
            System.out.println("Error: el porcentaje es erroneo");
        }
    }

}
