package Patrones.Factory.TiendaOnline;

public class Metal implements ProductoTienda{

    @Override
    public void fabricarProducto() {
        System.out.println("*** Fabricando el producto Metal ***");
        System.out.println("--------------------------------");
    }

    @Override
    public void empacarProducto() {
        System.out.println("*** Empacando producto Metal ***");
        System.out.println("--------------------------------");
    }

    @Override
    public void pepidoProducto() {
        System.out.println("*** Enviando el pedido producto Metal");
        System.out.println("--------------------------------");
    }
}
