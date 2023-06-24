package Patrones.Factory.TiendaOnline;

public class FabricaProductoVidrio extends FabricaTienda{
    @Override
    ProductoTienda comprarProducto() {
        return new Vidrio();
    }
}
