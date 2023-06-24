package Tienda;

public class MaderaProducto implements InterfaceProducto {
    @Override
    public void compararMateriales() {
        System.out.println("/////COMPRA DE MATERIALES MADERA /////");
        System.out.println("compramos la madera ");
        System.out.println("compramos los clavos ");
        System.out.println("pegamentos");
    }

    @Override
    public void fabricar() {
        System.out.println("/////FABRICACION MADERA/////");
        System.out.println("cortamos la madera ");
        System.out.println("clavamos la madera");
        System.out.println("pegamos la mader");
    }

    @Override
    public void entregar() {
        System.out.println("/////ENTREGA MADERA/////");
        System.out.println("enbolsamos el producto");
        System.out.println("encajonamos el producto");
    }
}
