package Patrones.Factory.TiendaOnline;

public class Madera implements ProductoTienda{
    @Override
    public void fabricarProducto() {
        System.out.println("*** Fabricando el producto Madera ***");
        System.out.println("--------------------------------");
    }

    @Override
    public void empacarProducto() {
        System.out.println("*** Empacando el producto Madera ***");
        System.out.println("--------------------------------");
    }

    @Override
    public void pepidoProducto() {
        System.out.println("*** Enviando el pedido producto Madera ***");
        System.out.println("--------------------------------");
    }
}
