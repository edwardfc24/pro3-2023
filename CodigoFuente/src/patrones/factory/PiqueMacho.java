package patrones.factory;

public class PiqueMacho implements ProductoComida{
    @Override
    public void preparar() {
        System.out.println("/////// Preparando Pique ////////");
        System.out.println("Cortar la Carne");
        System.out.println("Pelar la papa, cortar el resto de ingredientes");
        System.out.println("////////////////////////////////");
    }

    @Override
    public void cocinar() {
        System.out.println("/////// Cocinando Pique ////////");
        System.out.println("Sellar la carne, agregar a una olla aguar y el resto de los ingredientes ");
        System.out.println("Fritar las papas");
        System.out.println("////////////////////////////////");
    }

    @Override
    public void servir() {
        System.out.println("/////// Servir Pique ////////");
        System.out.println("Colocar en un plato plano la carne mezclada con las papas");
        System.out.println("Agregar locoto, huevo hervido en rodajas y salsas");
        System.out.println("////////////////////////////////");
    }
}
