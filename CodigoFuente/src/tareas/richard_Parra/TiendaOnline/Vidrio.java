package Patrones.Factory.TiendaOnline;

public class Vidrio implements ProductoTienda{
    @Override
    public void fabricarProducto() {
        System.out.println("*** Fabricando el producto Vidrio ***");
        System.out.println("--------------------------------");
    }

    @Override
    public void empacarProducto() {
        System.out.println("*** Empacando el producto Vidrio ***");
        System.out.println("--------------------------------");
    }

    @Override
    public void pepidoProducto() {
        System.out.println("*** Enviando el pedido producto vidrio ***");
        System.out.println("--------------------------------");
    }
}
