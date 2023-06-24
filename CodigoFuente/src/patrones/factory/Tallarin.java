package patrones.factory;

public class Tallarin implements ProductoComida{
    @Override
    public void preparar() {
        System.out.println("/////// PreparandoTallarin ////////");
        System.out.println("Estirar la masa");
        System.out.println("Preparar Salsa");
        System.out.println("Agregar ingredientes");
        System.out.println("////////////////////////////////");
    }

    @Override
    public void cocinar() {
        System.out.println("/////// Cocinando Tallarin ////////");
        System.out.println("Hervir agua con un toque de aceite y sal");
        System.out.println("Colocar los tallarines");
        System.out.println("Cocinar la salsa");
        System.out.println("////////////////////////////////");
    }

    @Override
    public void servir() {
        System.out.println("/////// Servir Tallarin ////////");
        System.out.println("Colocar en un plato hondo los tallarines");
        System.out.println("Servir Salsa encima");
        System.out.println("////////////////////////////////");
    }
}
