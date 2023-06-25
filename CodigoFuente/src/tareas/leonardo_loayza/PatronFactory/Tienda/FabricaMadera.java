package Factory.Tienda;
public class FabricaMadera extends FabricaProducto {
    @Override
    ProductoArtesanal crearProducto() {
        return new Madera();
    }
}