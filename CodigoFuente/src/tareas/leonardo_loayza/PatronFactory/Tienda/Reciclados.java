package Factory.Tienda;

public class Reciclados implements ProductoArtesanal {
    @Override
    public void crear() {
        System.out.println("Creando producto artesanal reciclado...");
        // Lógica específica para crear un producto artesanal reciclado
    }

    @Override
    public void empaquetar() {
        System.out.println("Empaquetando producto artesanal reciclado...");
        // Lógica específica para empaquetar un producto artesanal reciclado
    }

    @Override
    public void enviar() {
        System.out.println("Enviando producto artesanal reciclado...");
        // Lógica específica para enviar un producto artesanal reciclado
    }
}