package Factory.Tienda;

public class FabricaReciclado extends FabricaProducto {
    @Override
    ProductoArtesanal crearProducto() {
        return new Reciclados();
    }
}