package Patrones.Factory.TiendaOnline;

public class FabricaProductoMadera extends FabricaTienda{
    @Override
    ProductoTienda comprarProducto() {
        return new Madera();
    }
}
