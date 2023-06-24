package Tienda;

public class App {
    public static void main(String[] args) {
        FabricaProducto[] fabricas= new FabricaProducto[3];
        MaderaFabrica madera = new MaderaFabrica();
        MaderaFabrica madera2 = new MaderaFabrica();
        MetalFabrica metal = new MetalFabrica();
        fabricas[0] = madera;
        fabricas[1] = madera2;
        fabricas[2] = metal;
        Cliente cliente1= new Cliente(fabricas);

        cliente1.ordennar();
    }
}
