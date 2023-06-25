package Factory.Tienda;

class Madera implements ProductoArtesanal {
    @Override
    public void crear() {
        System.out.println("Creando producto artesanal de madera...");
    }

    @Override
    public void empaquetar() {
        System.out.println("Empaquetando producto artesanal de madera...");
    }

    @Override
    public void enviar() {
        System.out.println("Enviando producto artesanal de madera...");
    }
}