package Patrones.Factory.TiendaOnline;

public class FabricaProductoReciclaje extends FabricaTienda{
    @Override
    ProductoTienda comprarProducto() {
        return new Reciclaje();
    }
}
