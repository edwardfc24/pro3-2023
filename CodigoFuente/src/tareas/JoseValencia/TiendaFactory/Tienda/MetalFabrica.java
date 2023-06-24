package Tienda;

public class MetalFabrica extends FabricaProducto{

    @Override
    InterfaceProducto crearProducto() {
        return new MetalProducto();
    }
}
