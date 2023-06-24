package Tienda;

public class MetalProducto implements InterfaceProducto {
    @Override
    public void compararMateriales() {
        System.out.println("/////COMPRA DE MATERIALES METAL/////");
        System.out.println("compramos metal");
        System.out.println("comprmos soldaduras ");
        System.out.println("compramos remaches ");
    }

    @Override
    public void fabricar() {
        System.out.println("/////FABRICACION METAL/////");
        System.out.println("cortamos el metal");
        System.out.println("soldamos el metal");
        System.out.println("remachamos");
    }

    @Override
    public void entregar() {
        System.out.println("/////ENTREGA METAL/////");
        System.out.println("enbolsamos el producto");
        System.out.println("encajonamos el producto");
    }
}
