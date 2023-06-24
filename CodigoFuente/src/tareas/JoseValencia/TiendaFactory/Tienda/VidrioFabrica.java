package Tienda;

public class VidrioFabrica extends FabricaProducto{

    @Override
    InterfaceProducto crearProducto() {
        return new VidrioProducto();
    }
}
