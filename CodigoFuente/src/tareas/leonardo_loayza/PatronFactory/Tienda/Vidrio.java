package Factory.Tienda;

public class Vidrio implements ProductoArtesanal {
    @Override
    public void crear() {
        System.out.println("Creando producto artesanal de vidrio...");
    }

    @Override
    public void empaquetar() {
        System.out.println("Empaquetando producto artesanal de vidrio...");
    }

    @Override
    public void enviar() {
        System.out.println("Enviando producto artesanal de vidrio...");
    }
}