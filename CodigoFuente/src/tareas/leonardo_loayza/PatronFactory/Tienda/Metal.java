package Factory.Tienda;

public class Metal implements ProductoArtesanal {
    @Override
    public void crear() {
        System.out.println("Creando producto artesanal de metal...");
    }

    @Override
    public void empaquetar() {
        System.out.println("Empaquetando producto artesanal de metal...");
    }

    @Override
    public void enviar() {
        System.out.println("Enviando producto artesanal de metal...");
    }
}