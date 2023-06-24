package Patrones.Factory.TiendaOnline;

public class Reciclaje implements ProductoTienda{

    @Override
    public void fabricarProducto() {
        System.out.println("*** Fabricando el producto Reciclado ***");
        System.out.println("--------------------------------");
    }

    @Override
    public void empacarProducto() {
        System.out.println("*** Empacar el producto Recilado ***");
        System.out.println("--------------------------------");
    }

    @Override
    public void pepidoProducto() {
        System.out.println("*** Enviando el pedido producto reciclado ***");
        System.out.println("--------------------------------");
    }
}
