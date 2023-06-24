package patrones.factory;

public class FabricaMain {
    public static void main(String[] args) {
        FabricaTallarin fabricaTallarin = new FabricaTallarin();
        FabricaPiqueMacho fabricaPiqueMacho = new FabricaPiqueMacho();
        // Creamos los clientes
        Cliente juanito = new Cliente(fabricaTallarin);
        Cliente pepito = new Cliente(fabricaPiqueMacho);
        // Ordenemos
        juanito.ordenarComida();
        System.out.println("/////////////////////////");
        pepito.ordenarComida();

    }
}
