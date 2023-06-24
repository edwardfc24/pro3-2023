package Tienda;

public class Cliente {
    private InterfaceProducto[] productoList = new InterfaceProducto[3];

    public Cliente(FabricaProducto[] producto){
        for(int i = 0 ; i< producto.length; i++) {
            productoList[i] = producto[i].crearProducto();
        }
    }

    public void ordennar(){
        for(int i = 0 ; i< productoList.length; i++) {
            System.out.println();
            System.out.println("Producto: " + i);
            productoList[i].compararMateriales();
            productoList[i].fabricar();
            productoList[i].entregar();
        }
    }
}
