package Factory.Tienda;

public class FabricaMetal extends FabricaProducto {
    @Override
    ProductoArtesanal crearProducto() {
        return new Metal();
    }
}