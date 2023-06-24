package Tienda;

public class ReciclarProducto implements InterfaceProducto {
    @Override
    public void compararMateriales() {
        System.out.println("/////COMPRA DE MATERIALES RECICLAR /////");
        System.out.println("recolectamos los productos");
        System.out.println("compramos las isocolas ");
        System.out.println("compramos extras ");
    }

    @Override
    public void fabricar() {
        System.out.println("/////FABRICACION RECICLAR/////");
        System.out.println("limpiamos lo reciclado");
        System.out.println("cortamos ");
        System.out.println("pegamos");
    }

    @Override
    public void entregar() {
        System.out.println("/////ENTREGA RECICLAR/////");
        System.out.println("enbolsamos el producto");
        System.out.println("encajonamos el producto");
    }
}
