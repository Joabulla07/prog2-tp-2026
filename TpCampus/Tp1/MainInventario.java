package TpCampus.Tp1;

public class MainInventario {
    public static void main(String[] args){

        Producto productoUno = new Producto("Alfajor", "C2525", 2400.5, 100);
        Producto productoDos = new Producto("Agua mineral sin gas", "A4526", 1500.0, 250);
        Producto productoTres = new Producto("Chocolate", "G4586", 2550.2, 20);

        Producto[] listaProd = {productoUno, productoDos, productoTres};

        System.out.println("=== Productos ===");

        for(Producto items: listaProd){
            items.mostrarFicha();
        }

        System.out.println("=================");

        System.out.println("=== Vender Unidades ===");
        productoUno.venderUnidades(50);
        productoDos.venderUnidades(260);
        productoTres.venderUnidades(-3);

        System.out.println("=== Reponer Stock ===");
        productoUno.reponerStock(100);
        productoDos.reponerStock(20);
        productoTres.reponerStock(-5);

        System.out.println("=== Actualizar Precio ===");
        productoUno.actualizarPrecio(1500.00);
        productoDos.actualizarPrecio(100);
        productoTres.actualizarPrecio(5000.50);

        System.out.println("=== Aplica Descuento ===");
        productoUno.aplicarDescuento(50);
        productoDos.aplicarDescuento(70);
        productoTres.aplicarDescuento(-5);

        System.out.println("\n=== Demostración de aliasing de referencias ===");
        System.out.println("Stock original de productoUno: " + productoUno.stock);
        
        Producto copia = productoUno;
        copia.stock = 29;
        
        System.out.println("Stock de copia después de modificar: " + copia.stock);
        System.out.println("Stock de productoUno después de modificar copia: " + productoUno.stock);
        System.out.println("productoUno y copia son la MISMA referencia, apuntando al mismo objeto en el Heap.");

    }
}
