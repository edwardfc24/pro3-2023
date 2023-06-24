package Tienda;

public class ReciclarFabrica extends FabricaProducto{

    @Override
    InterfaceProducto crearProducto() {
        return new ReciclarProducto();
    }
}
