package Patrones.Factory.TiendaOnline;

public class FabricaProductoMetal extends FabricaTienda{
    @Override
    ProductoTienda comprarProducto() {
        return new Metal();
    }
}
