package Patrones.Factory.TiendaOnline;

public class AppTienda {
    public static void main(String[] args) {
        FabricaProductoVidrio fabricaVidrio = new FabricaProductoVidrio();
        FabricaProductoMadera fabricaMadera = new FabricaProductoMadera();

        //Clientes
        Cliente leonardo = new Cliente(fabricaVidrio);
        Cliente joseMaria = new Cliente(fabricaMadera);

        //orden del cliente
        leonardo.ordenarProducto();
        System.out.println("||** Cliente sastifecho **||");
        System.out.println("============================");
        joseMaria.ordenarProducto();
        System.out.println("||** Cliente sastifecho **||");
    }
}
