
package Tienda;

import java.sql.SQLOutput;

public class VidrioProducto implements InterfaceProducto {
    @Override
    public void compararMateriales() {
        System.out.println("//////COMPRA DE MATERIALES VIDRIO//////");
        System.out.println("vamos a la ferrteria");
        System.out.println("se compra los materiales");
    }

    @Override
    public void fabricar() {
        System.out.println("FABRICAMOS VIDRIO");
        System.out.println("cortamos la bandera");
        System.out.println("colocamos los clavos");
    }

    @Override
    public void entregar() {
        System.out.println("/////ENTREGA VIDRIO/////");
        System.out.println("enbolsamos el producto");
        System.out.println("encajonamos el producto");
    }
}
