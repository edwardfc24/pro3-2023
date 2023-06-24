package Tienda;

public class MaderaFabrica extends FabricaProducto{

    @Override
    InterfaceProducto crearProducto() {
        return new MaderaProducto();
    }
}
