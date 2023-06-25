package Factory.Tienda;



public class FabricaMain {
    public static void main(String[] args) {

        FabricaMadera fabricaMadera = new FabricaMadera();
        FabricaVidrio fabricaVidrio = new FabricaVidrio();
        Cliente richard = new Cliente(fabricaVidrio);
        richard.ordenarProducto();

        System.out.println("----------------------------------");
        Cliente jorge = new Cliente(fabricaMadera);
        jorge.ordenarProducto();




    }
}
