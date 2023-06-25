package Factory.Tienda;


public class Cliente {
    private ProductoArtesanal producto;
    public Cliente(FabricaProducto fabrica){
        producto = fabrica.crearProducto();
    }
    public void ordenarProducto(){
        producto.crear();
        producto.empaquetar();
        producto.enviar();
    }
}