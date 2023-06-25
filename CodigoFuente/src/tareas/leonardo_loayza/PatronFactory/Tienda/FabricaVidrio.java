package Factory.Tienda;

public class FabricaVidrio extends FabricaProducto {
    @Override
    ProductoArtesanal crearProducto() {
        return new Vidrio();
    }
}